package org.example.devops_mini_back.dto.ExerciseFavorite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseFavoriteResponseDto {
    private int favoriteId;
    private int userId;
    private String exerciseName;
    private int youtubeId;
    private int kcal;
    private String picture;
}
