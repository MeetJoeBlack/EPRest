package com.dao;

import com.model.Employee;
import org.hsqldb.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO layer interface implementation for {@link Employee Employee} model
 * @author Gabriel
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final String FIND_ALL_EMPS = "SELECT * FROM employee" ;
    private final String FIND_BY_ID = "SELECT * FROM employee WHERE id=?" ;
    private final String DELETE_EMP = "DELETE FROM employee WHERE id=?";
    private final String UPDATE_EMP = "UPDATE employee set depId=?, fio=?, birth=? , salary=? where id=?";
    private final String FIND_BY_BIRTH = "SELECT * FROM employee WHERE birth between ? AND ?" ;

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Employee> findByBirth(String start, String end) {
        List<Employee> empList =  new JdbcTemplate(dataSource).query(FIND_BY_BIRTH, new String[]{start, end}, new EmployeeMapper());
        return empList;
    }

    @Override
    public Employee findById(Long id) {
        List<Employee> empList =  new JdbcTemplate(dataSource).query(FIND_BY_ID, new EmployeeMapper(), id);
        return empList !=null && empList.size() > 0 ? empList.get(0) : null;
    }
    @Override
    public List<Employee> findAll(){
        List<Employee> employees =  new JdbcTemplate(dataSource).query(FIND_ALL_EMPS, new EmployeeMapper());
        return employees;
    }

    public void performDML(String sql, Object[] params, int[] types){
        new JdbcTemplate(dataSource).update(sql, params, types);
    }

    @Override
    public void update(Employee employee){
        performDML(UPDATE_EMP, new Object[]{employee.getDepId(),
                employee.getFio(), employee.getBirth(), employee.getSalary(), employee.getId()},
                new int[] { Types.INTEGER , Types.VARCHAR, Types.DATE, Types.INTEGER, Types.INTEGER });
    }

    @Override
    public void delete(Long id){
        performDML(DELETE_EMP, new Object[]{id}, new int[] { Types.INTEGER });
    }

    @Override
    public long insert(Employee employee){

        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("depId", employee.getDepId());
        parameters.put("fio", employee.getFio());
        parameters.put("salary", employee.getSalary());
        parameters.put("birth", employee.getBirth());

        return new SimpleJdbcInsert(dataSource).withTableName("employee").usingGeneratedKeyColumns("id").executeAndReturnKey(parameters).longValue();
    }

    private static final class EmployeeMapper implements RowMapper<Employee> {

        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setDepId(rs.getLong("depId"));
            employee.setFio(rs.getString("fio"));
            employee.setBirth(rs.getDate("birth"));
            employee.setSalary(rs.getInt("salary"));
            return employee;
        }
    }
}
