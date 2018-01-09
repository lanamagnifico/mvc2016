package com.mvc.common.service;

import com.mvc.common.model.Person;
import java.util.List;

public interface PersonService{

    List<Person> findAll();

    Person findById(int id);

    boolean save(Person person);

    boolean update(Person person);
}
