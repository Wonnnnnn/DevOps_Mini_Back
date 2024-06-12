package org.example.devops_mini_back.dto.IntakeCalorie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntakeCalorieUpdateDto {
    private String date;
    private int breakfast;
    private int lunch;
    private int dinner;
    private int snack;
    private int userId;
}
