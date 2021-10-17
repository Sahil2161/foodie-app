package com.cgi.foodie.service;

import com.cgi.foodie.dao.RecoveryDao;
import com.cgi.foodie.model.Recovery;
import com.cgi.foodie.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryServiceImpl implements RecoveryService{
    @Autowired
    RecoveryDao recoveryDao;

    @Override
    public Recovery checkDetails(Recovery details) {
        return recoveryDao.checkDetails(details);
    }

    @Override
    public User resetPassword(User updatedUser) {
        return recoveryDao.resetPassword(updatedUser);
    }
}
