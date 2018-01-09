package com.mvc.common.service;

import com.mvc.common.model.User;

import java.io.IOException;
import java.util.List;

public interface UserService{
    User findByName(String name);

    List<User> findAll();

    boolean save(User user);

    boolean update(User user);

    String getUserImage(User user) throws IOException;
}
