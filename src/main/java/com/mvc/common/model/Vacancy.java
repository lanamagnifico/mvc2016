package com.mvc.common.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Vacancy {

    private int id;
    @NotNull
    private String name;
    @NotNull
    private Position position;
    private Department department;
    private Date openDate;
    @NotNull
    private boolean closed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    @Override
    public String toString(){
        return name;
    }
}
