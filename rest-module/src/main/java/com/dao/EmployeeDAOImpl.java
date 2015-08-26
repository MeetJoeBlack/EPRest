package com.dao;

import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Gabriel on 8/27/2015.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final String FIND_ALL_EMPS = "SELECT * FROM employee" ;

    @Autowired
    private DataSource dataSource;


    public List<Employee> findAll(){
        List<Employee> employees =  new JdbcTemplate(dataSource).query(FIND_ALL_EMPS, new EmployeeMapper());
        return employees;
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
