package com;


import com.config.TestDBconfig;
import com.config.WebAppConfig;
import com.dao.EmployeeDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;

/**
 * Created by Gabriel on 4/2/2015.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDBconfig.class, WebAppConfig.class})
@ActiveProfiles("unit-test")
public class JdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    public void rowCount() {
        int rowCount =  jdbcTemplate.queryForObject("select count(*) from employee", Integer.class);
        System.out.println("test db rows: "  + rowCount);
        Assert.assertEquals(1, rowCount);
    }

    @Test
    public void findAll() {
        System.out.println("test db rows: "  + employeeDAO.findAll());
        Assert.assertEquals(1, employeeDAO.findAll().size());
    }



}
