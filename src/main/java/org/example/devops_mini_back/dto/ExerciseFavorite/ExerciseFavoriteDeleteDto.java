package org.example.devops_mini_back.dto.ExerciseFavorite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseFavoriteDeleteDto {
    private int userId;
    private int exerciseId;
}
