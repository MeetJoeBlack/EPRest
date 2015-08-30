package com;


import com.config.TestDBconfig;
import com.config.WebAppConfig;
import com.dao.EmployeeDAO;
import com.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Database configuration class
 * @author Gabriel
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDBconfig.class, WebAppConfig.class})
@ActiveProfiles("unit-test")
public class EmpDaoTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    public void insert(){
        System.out.println("test db rows: "  + employeeDAO.findAll());
        List<Employee> employees = employeeDAO.findAll();
        assertEquals(1, employees.size());

        Employee employee = new Employee(null, 1L, "Test Employee", new java.sql.Date(new java.util.Date().getTime()), 3000 );
        assertNotNull(employee);
        long id = employeeDAO.insert(employee);

        Employee employee1 = employeeDAO.findById(id);
        assertNotNull(employee1);

        assertEquals(employee.getDepId(), employee1.getDepId());
        assertEquals(employee.getFio(), employee1.getFio());
        assertEquals(employee.getSalary(), employee1.getSalary());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(dateFormat.format(employee1.getBirth()));
        assertEquals(dateFormat.format(employee.getBirth()), dateFormat.format(employee1.getBirth()));
    }

    @Test
    public void updateEmp(){
        Employee employee = new Employee(null, 1L, "Test Employee", new java.sql.Date(new java.util.Date().getTime()), 3000);
        long id = employeeDAO.insert(employee);

        Employee changedEmp = new Employee(id, 1L, "Test Employee (changed)", new java.sql.Date(new java.util.Date().getTime() - 2000L), 5000);
        employeeDAO.update(changedEmp);

        Employee employee2 = employeeDAO.findById(changedEmp.getId());
        assertNotNull(employee2);

        assertEquals(changedEmp.getDepId(), employee2.getDepId());
        assertEquals(changedEmp.getFio(), employee2.getFio());
        assertEquals(changedEmp.getSalary(), employee2.getSalary());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        assertEquals(dateFormat.format(changedEmp.getBirth()), dateFormat.format(employee2.getBirth()));

    }

    @Test
    public void deleteEmp(){
        Employee employee = new Employee(null, 1L, "Test Employee", new java.sql.Date(new java.util.Date().getTime()), 3000);
        long id = employeeDAO.insert(employee);
        employeeDAO.delete(id);
        assertNull(employeeDAO.findById(id));
    }


    @Test
    public void findByDate(){
        String startDate = "1970-08-22";
        String endDate = "2000-01-01";
        assertEquals(1, employeeDAO.findByBirth(startDate, endDate).size());
    }



}
