package com.dao;

import com.model.Employee;

import java.util.List;

/**
 * Created by Gabriel on 8/27/2015.
 */
public interface EmployeeDAO {
    List<Employee> findAll();
}
