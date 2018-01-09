package com.mvc.common.dao;

import com.mvc.common.model.User;
import java.util.List;

public interface UserDao {

    User findByName(String name);

    List<User> findAll();

    boolean save(User user);

    boolean update(User user);
}
