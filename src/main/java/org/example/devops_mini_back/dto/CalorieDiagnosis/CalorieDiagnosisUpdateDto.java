package org.example.devops_mini_back.dto.CalorieDiagnosis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalorieDiagnosisUpdateDto {
    private int userId;
    private double monthUnit;
    private double goalKg;
    private double bmr;
    private double amr;
    private double tdee;
    private double eatNeeded;
    private double workoutNeeded;
}
