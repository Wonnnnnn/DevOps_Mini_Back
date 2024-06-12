package org.example.devops_mini_back.controller;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.Food.FoodCreateDto;
import org.example.devops_mini_back.dto.Food.FoodUpdateDto;
import org.example.devops_mini_back.entity.Food;
import org.example.devops_mini_back.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @GetMapping
    public List<Food> getAllFood() {
        return foodService.getAllFood();
    }

    @GetMapping("/{foodId}")
    public Food getFood(@PathVariable("foodId") int foodId) {
        return foodService.getFoodById(foodId);
    }

    @PostMapping
    public Food addFood(@RequestBody FoodCreateDto foodCreateDto) {
        return foodService.addFood(foodCreateDto);
    }

    @PutMapping
    public Food updateFood(@RequestBody FoodUpdateDto foodUpdateDto) {
        return foodService.updateFood(foodUpdateDto);
    }

    @DeleteMapping("/{foodId}")
    public void deleteFood(@PathVariable("foodId") int foodId) {
        foodService.deleteFood(foodId);
    }

}
