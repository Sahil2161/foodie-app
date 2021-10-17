package com.cgi.foodie.dao;

import com.cgi.foodie.model.Recovery;
import com.cgi.foodie.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RecoveryDao {
    @Autowired
    MongoTemplate mongoTemplate;

    public Recovery checkDetails(Recovery details) {
        Query query = new Query();
        query.addCriteria(Criteria.where("emailId").is(details.getEmailId()));
        query.addCriteria(Criteria.where("securityQuestion").is(details.getSecurityQuestion()));
        query.addCriteria(Criteria.where("securityAnswer").is(details.getSecurityAnswer()));

        return new Recovery();
    }

    public User resetPassword(User updatedUser) {
        return new User();
    }
}
