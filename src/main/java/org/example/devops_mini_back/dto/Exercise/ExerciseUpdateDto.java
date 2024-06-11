package org.example.devops_mini_back.dto.Exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseUpdateDto {
    private int exerciseId;
    private int kcal;
    private int youtubeId;
    private String picture;
}
