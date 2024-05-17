package com.example.kycapp2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    private String username;
    private String email;
    private String password;
    private String mobileNumber;
    private String birthdate;
    private String nationalId;
    private String gender;
}
