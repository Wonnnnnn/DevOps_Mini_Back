package org.example.devops_mini_back.dto.Food;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodUpdateDto {
    private int foodId;
    private double kcal;
    private String picture;
}
