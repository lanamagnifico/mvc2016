package com.mvc.common.service.impl;

import com.mvc.common.dao.UserDao;
import com.mvc.common.model.User;
import com.mvc.common.service.UserService;
import com.mvc.common.util.AuthenticationUtils;
import com.mvc.common.util.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    ServletContext context;

    @Override
    public User findByName(String name) {
        User user = userDao.findByName(name);
        return user;
    }

    public String getUserImage(User user) throws IOException {
        String imageSrc = user.getImageSrc();
        if (imageSrc == null) {
            imageSrc = context.getRealPath("/WEB-INF")+"/unknown-user.jpg";
        }
        return ConvertUtils.convertFileToStrBase64(imageSrc);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean save(User user) {
        user.setPassword(AuthenticationUtils.getPasswordEnconer().encode(user.getPassword()));
        return userDao.save(user);
    }

    public boolean update(User user) {
        return userDao.update(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
