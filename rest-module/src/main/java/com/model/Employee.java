package com.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import java.sql.Date;

/**
 * Employee model POJO
 * @author Gabriel
 */
public class Employee {
    Long id;
    Long depId;
    String fio;
    Date birth;
    Integer salary;

    public Employee() {
    }

    public Employee(Long id, Long depId, String fio, Date birth, Integer salary) {
        this.id = id;
        this.depId = depId;
        this.fio = fio;
        this.birth = birth;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @JsonSerialize(using=DateSerializer.class)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", depId=" + depId + ", fio=" + fio  + "," +
                " birth=" + birth +   ", salary=" + salary + "]";
    }
}
