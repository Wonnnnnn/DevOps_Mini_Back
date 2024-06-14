package org.example.devops_mini_back.dto.FoodFavorite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodFavoriteDeleteDto {
    private int userId;
    private int foodId;
}
