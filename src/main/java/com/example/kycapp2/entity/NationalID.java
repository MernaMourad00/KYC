package com.example.kycapp2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "National_Id")
public class NationalID {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String address;
    private String nationalId;
    private String birthdate;
    private String gender;
    private IdStatus idStatus;
    private Double contractAmount;
    private String frontIdImage;
    private String rejectionComment;
    private String manufactureNumber;

}
