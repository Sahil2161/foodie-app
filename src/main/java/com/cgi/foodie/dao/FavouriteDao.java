package com.cgi.foodie.dao;

import com.cgi.foodie.model.Favourite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavouriteDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Favourite> getFavourites(String emailId) {
        Query q = new Query();
        q.addCriteria(Criteria.where("emailId").is(emailId));
        return mongoTemplate.find(q, Favourite.class);
    }

    public Favourite addFavourite(Favourite favourite) {
        return mongoTemplate.save(favourite);
    }


    public int removeFavourite(int restId, String emailId) {

        Query q = new Query();
        q.addCriteria(Criteria.where("emailId").is(emailId));
        q.addCriteria(Criteria.where("restId").is(restId));

        mongoTemplate.findAllAndRemove(q, Favourite.class);
        return restId;
    }

}
