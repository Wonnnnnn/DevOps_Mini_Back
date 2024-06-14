package org.example.devops_mini_back.dto.FoodFavorite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodFavoriteResponseDto {
    private int favoriteId;
    private int userId;
    private String foodName;
    private double kcal;
    private String picture;
}
