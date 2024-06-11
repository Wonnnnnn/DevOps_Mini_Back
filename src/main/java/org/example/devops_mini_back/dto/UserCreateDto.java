package org.example.devops_mini_back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    private String id;
    private String password;
    private String username;
    private double bmi;
}
