package org.example.devops_mini_back.dto.Exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseUpdateDto {
    private int exerciseId;
    private double kcal;
    private String youtubeId;
    private String picture;
}
