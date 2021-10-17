package com.cgi.foodie.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recovery {
    private String emailId;
    private String securityQuestion;
    private String securityAnswer;


}
