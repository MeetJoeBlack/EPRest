package com.dao;

import com.model.DepSalary;
import com.model.Department;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;

/**
 * DAO layer interface implementation for {@link Department Department} model
 * @author Gabriel
 */
public class DepartmentDaoImpl implements DepartmentDao {

    private final String FIND_ALL_DEPS = "SELECT * FROM department" ;
    private final String FIND_BY_ID = "SELECT * FROM department WHERE id=?" ;
    private final String DELETE_DEP = "DELETE FROM department WHERE id=?";
    private final String UPDATE_DEP = "UPDATE department set depId=?, fio=?, birth=? , salary=? where id=?";
    private final String FIND_AVG_SALARY = "select dep.id, dep.name , (select nvl(avg(e.salary), 0) from  employee e where  dep.id = e.depid ) from department dep" ;

    @Autowired
    private DataSource dataSource;


    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public List<DepSalary> getDepsWithAvgSalary() {
        return null;
    }

    @Override
    public long insert(Department department) {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Department department) {

    }

    @Override
    public Department findById(Long id) {
        return null;
    }
}
