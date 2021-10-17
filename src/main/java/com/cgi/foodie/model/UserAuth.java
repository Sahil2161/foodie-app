package com.cgi.foodie.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserAuth {
    @Id
    private String emailId;
    private String password;
    private String pic;
}
