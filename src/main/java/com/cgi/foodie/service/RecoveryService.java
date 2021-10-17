package com.cgi.foodie.service;

import com.cgi.foodie.model.Recovery;
import com.cgi.foodie.model.User;
import org.springframework.stereotype.Service;

@Service
public interface RecoveryService {
    Recovery checkDetails(Recovery details);
    User resetPassword(User updatedUser);
}
