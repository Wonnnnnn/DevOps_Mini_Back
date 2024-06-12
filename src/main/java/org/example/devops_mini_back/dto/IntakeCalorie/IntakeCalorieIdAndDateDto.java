package org.example.devops_mini_back.dto.IntakeCalorie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntakeCalorieIdAndDateDto {
    private int userId;
    private Date date;
}
