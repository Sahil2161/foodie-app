package com.cgi.foodie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Document(collection="favourites")
public class Favourite {

    // should be unique; here combination of restName and emailId
    @Id
    private String id;

    // restaurant id, not unique in this context
    private int restId;
    private String emailId;
    // restaurant name
    private String name;
    private String city;
    private String thumbnail;

    public Favourite(String id, int restId, String emailId, String name, String city, String thumbnail) {
        this.id = String.format("%s@%s",this.name, this.emailId);
        this.restId = restId;
        this.emailId = emailId;
        this.name = name;
        this.city = city;
        this.thumbnail = thumbnail;
    }
}
