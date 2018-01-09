package com.mvc.common.model;

import javax.validation.constraints.NotNull;

public class Applicant {
    private int id;

    @NotNull
    private String name;

    @NotNull
    private Position position;

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

    @Override
    public String toString(){
        return name;
    }
}
