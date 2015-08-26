package com.model;

import java.sql.Date;

/**
 * Created by Gabriel on 8/27/2015.
 *
 */
public class Employee {
    Long id;
    Long depId;
    String fio;
    Date birth;
    Integer salary;

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
        return "Employee [id=" + id + ", depId=" + depId + ", fio=" + fio + "]" + ", fio=" + fio + "]" + "," +
                " birth=" + birth + "]" + ", salary=" + salary + "]";
    }
}
