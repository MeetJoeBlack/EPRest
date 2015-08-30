package com.model;

/**
 * Department with average employees salary model POJO
 * @author Gabriel
 */
public class DepSalary extends Department{
    Integer salary;

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
    
        this.salary = salary;
    }
}
