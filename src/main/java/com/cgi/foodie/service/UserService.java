package com.cgi.foodie.service;

import com.cgi.foodie.model.User;
import com.cgi.foodie.model.UserAuth;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUser(UserAuth userAuth);
    User saveUser(User user);
}
