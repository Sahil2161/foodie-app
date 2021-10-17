package com.cgi.foodie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.foodie.dao.UserDao;
import com.cgi.foodie.model.User;
import com.cgi.foodie.model.UserAuth;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User saveUser(User user) {
        if(!userDao.userExists(user)) {
            return userDao.saveUser(user);
        }
        return null;
    }

    @Override
    public User getUser(UserAuth userAuth) {
        // if user details do not match in database return null
        // all fields will be null if not found in db
        if(userAuth.getEmailId() == null) {
            return null;
        }
        return userDao.getUser(userAuth);
    }

}
