package com.dao;

import com.model.DepSalary;
import com.model.Department;

import java.util.List;

/**
 * DAO layer interface  for {@link Department Department} model
 * @author Gabriel
 */
public interface DepartmentDao {
    List<Department> findAll();
    List<DepSalary> getDepsWithAvgSalary();
    long insert(Department department);
    void delete(Long id);
    void update(Department department);
    Department findById(Long id);
}
