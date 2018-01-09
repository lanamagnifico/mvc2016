package com.mvc.common.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

public class Person {

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    private UUID uuid;
    private int id;
    @NotNull
    @Size(min=5, max=250, message="{person.name.valid}")
    private String name;
    @NotNull(message="{person.gender.valid}")
    private String gender;
    @NotNull(message="{person.birthday.valid}")
    private Date birthDay;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name + "(" + id + ") " + gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
