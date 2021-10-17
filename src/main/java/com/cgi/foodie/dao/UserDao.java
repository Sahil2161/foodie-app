package com.cgi.foodie.dao;

import com.cgi.foodie.model.User;
import com.cgi.foodie.model.UserAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    MongoTemplate mongoTemplate;

    public boolean userExists(User user) {
        Query q = new Query();
        q.addCriteria(Criteria.where("emailId").is(user.getEmailId()));
        return mongoTemplate.exists(q, User.class);
    }

    public User saveUser(User user) {
        return mongoTemplate.save(user);
    }

    public User getUser(UserAuth userAuth) {
        Query query = new Query();
        query.addCriteria(Criteria.where("emailId").is(userAuth.getEmailId()));
        query.addCriteria(Criteria.where("password").is(userAuth.getPassword()));
        return mongoTemplate.findOne(query, User.class);
    }

}
