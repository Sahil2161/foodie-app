package com.cgi.foodie.controller;

import com.cgi.foodie.model.Favourite;
import com.cgi.foodie.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/favourites")
public class FavouriteController {

    @Autowired
    FavouriteService favouriteService;

    @GetMapping()
    public ResponseEntity<List<Favourite>> getFavourites(
            @RequestParam(name="emailId") String emailId
    ) {

        return new ResponseEntity<>(
                favouriteService.getFavourites(emailId),
                HttpStatus.OK
        );
    }

    @PostMapping()
    public ResponseEntity<Favourite> addFavorite(@RequestBody Favourite favourite) {
        return new ResponseEntity<>(favouriteService.addFavourite(favourite), HttpStatus.OK);
    }

    // Fixme
    @DeleteMapping()
    public ResponseEntity<Integer> removeFavourite(@RequestParam int restId, @RequestParam String emailId) {
        return new ResponseEntity<>(favouriteService.removeFavourite(restId, emailId), HttpStatus.OK);
    }
}
