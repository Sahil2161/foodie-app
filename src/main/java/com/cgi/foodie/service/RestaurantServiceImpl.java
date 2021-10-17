package com.cgi.foodie.service;

import java.util.List;

import com.cgi.foodie.dao.RestaurantDao;
import com.cgi.foodie.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantDao restaurantDao;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantDao.getAllRestaurants();
    }

    @Override
    public List<Restaurant> getRestaurantsByName(String name) {
        return restaurantDao.getRestaurantsByName(name);
    }

    @Override
    public List<Restaurant> getRestaurantsByCity(String city) {
        return restaurantDao.getRestaurantsByCity(city);
    }

    @Override
    public List<Restaurant> getRestaurantsByCategory(String category) {
        return restaurantDao.getRestaurantsByCategory(category);
    }

}