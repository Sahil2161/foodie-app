package com.cgi.foodie.dao;

import com.cgi.foodie.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Restaurant> getAllRestaurants() {
        return mongoTemplate.findAll(Restaurant.class);
    }

    public List<Restaurant> getRestaurantsByName(String name) {
        Query q = new Query();
        q.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(q, Restaurant.class);
    }

    public List<Restaurant> getRestaurantsByCity(String city) {
        Query q = new Query();
        q.addCriteria(Criteria.where("city").is(city));
        return mongoTemplate.find(q, Restaurant.class);
    }

    public List<Restaurant> getRestaurantsByCategory(String category) {
        Query q = new Query();
        q.addCriteria(Criteria.where("category").is(category));
        return mongoTemplate.find(q, Restaurant.class);
    }
}

