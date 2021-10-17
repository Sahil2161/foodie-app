package com.cgi.foodie.service;

import com.cgi.foodie.model.Favourite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavouriteService {
    List<Favourite> getFavourites(String emailId);
    Favourite addFavourite(Favourite favourite);
    int removeFavourite(int restId, String emailId);
}
