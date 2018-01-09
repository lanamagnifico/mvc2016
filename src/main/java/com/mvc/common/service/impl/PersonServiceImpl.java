package com.mvc.common.service.impl;

import com.mvc.common.dao.PersonDao;
import com.mvc.common.model.Person;
import com.mvc.common.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl  implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public Person findById(int id) {
        return personDao.findById(id);
    }

    @Override
    public boolean save(Person person) {
        return personDao.save(person);
    }

    @Override
    public boolean update(Person person) {
        return personDao.update(person);
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}
