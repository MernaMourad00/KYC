package com.example.kycapp2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;
    @Field
    private String username;
    @Field
    private String email;
    @Field
    private String password;
    @Field
    private String mobileNumber;
    @Field
    private String birthdate;
    @Field
    private String nationalId;
    @Field
    private String gender;
    @Field
    private String role;

}
