package com.cgi.foodie.service;

import java.util.List;

import com.cgi.foodie.model.Restaurant;
import org.springframework.stereotype.Service;


@Service
public interface RestaurantService {

    List<Restaurant> getAllRestaurants();

    List<Restaurant> getRestaurantsByName(String name);

    List<Restaurant> getRestaurantsByCity(String city);

    List<Restaurant> getRestaurantsByCategory(String category);

}