package com.example.kycapp2.payload;

import com.example.kycapp2.entity.IdStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNationalIdDTO {
    private IdStatus idStatus;
    private String comment;
}
