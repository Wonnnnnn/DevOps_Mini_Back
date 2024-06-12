package org.example.devops_mini_back.dto.BurnCalorie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BurnCalorieDeleteDto {
    private int userId;
    private Date date;
}
