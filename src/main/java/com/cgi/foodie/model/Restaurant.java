package com.cgi.foodie.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "restaurants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    int id;
    private String category;
    private String name;
    private String city;
    private String thumbnail;
    private Dish[] menu;
}