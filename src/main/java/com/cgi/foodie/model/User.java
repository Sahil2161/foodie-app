package com.cgi.foodie.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection="users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String emailId;
    private String fullName;
    private long phoneNumber;
    private String password;
    private String gender;
    private String pic;

    // for recovery
    private String securityQuestion;
    private String securityAnswer;
}
