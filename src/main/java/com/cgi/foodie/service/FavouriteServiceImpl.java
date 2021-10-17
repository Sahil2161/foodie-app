package com.cgi.foodie.service;

import com.cgi.foodie.dao.FavouriteDao;
import com.cgi.foodie.model.Favourite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService{

    @Autowired
    FavouriteDao favouriteDao;

    @Override
    public List<Favourite> getFavourites(String emailId) {
        return favouriteDao.getFavourites(emailId);
    }

    @Override
    public Favourite addFavourite(Favourite favourite) {
        return favouriteDao.addFavourite(favourite);
    }

    @Override
    public int removeFavourite(int restId, String emailId) {
        return favouriteDao.removeFavourite(restId, emailId);
    }
}
