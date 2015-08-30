package com.dao;

import com.model.Employee;

import java.util.List;

/**
 * DAO layer interface  for {@link Employee Employee} model
 * @author Gabriel
 */
public interface EmployeeDAO {
    List<Employee> findAll();
    List<Employee> findByBirth(String start, String end);
    long insert(Employee employee);
    void delete(Long id);
    void update(Employee employee);
    Employee findById(Long id);
}
