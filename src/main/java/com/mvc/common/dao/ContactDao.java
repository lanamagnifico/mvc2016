package com.mvc.common.dao;

import com.mvc.common.model.Contact;
import java.util.Date;
import java.util.List;

public interface ContactDao {

    List<Contact> findAll();

    Contact findById(int id);

    boolean save(Contact contact);

    boolean update(Contact contact);

    boolean delete(Contact contact);

    List<Contact> findByDay(Date date);

}
