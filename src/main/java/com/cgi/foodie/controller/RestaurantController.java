package com.cgi.foodie.controller;

import com.cgi.foodie.model.Restaurant;
import com.cgi.foodie.service.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;



    @GetMapping(path="get")
    public ResponseEntity<List<Restaurant>> getRestaurantByName(
            @RequestParam(required=false) String name,
            @RequestParam(required=false) String city,
            @RequestParam(required=false) String category)
    {

        if(name != null) {
            List<Restaurant> savedRestaurants = restaurantService.getRestaurantsByName(name);
            return new ResponseEntity<>(savedRestaurants, HttpStatus.OK);
        } else if(city != null) {
            List<Restaurant> savedRestaurants = restaurantService.getRestaurantsByCity(city);
            return new ResponseEntity<>(savedRestaurants, HttpStatus.OK);
        } else if(category != null) {
            List<Restaurant> savedRestaurants = restaurantService.getRestaurantsByCategory(category);
            return new ResponseEntity<>(savedRestaurants, HttpStatus.OK);
        }

        return new ResponseEntity("Cannot find", HttpStatus.NOT_FOUND);
    }

    @GetMapping(path="/")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
}
