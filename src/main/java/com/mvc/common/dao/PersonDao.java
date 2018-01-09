package com.mvc.common.dao;

import com.mvc.common.model.Person;
import java.util.List;

public interface PersonDao {

    List<Person> findAll();

    Person findById(int id);

    boolean save(Person person);

    boolean update(Person person);

    boolean delete(Person person);
}
