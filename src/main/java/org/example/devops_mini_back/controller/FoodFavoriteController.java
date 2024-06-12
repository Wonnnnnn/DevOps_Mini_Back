package org.example.devops_mini_back.controller;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.Food.FoodCreateDto;
import org.example.devops_mini_back.dto.FoodFavorite.FoodFavoriteCreateDto;
import org.example.devops_mini_back.dto.FoodFavorite.FoodFavoriteResponseDto;
import org.example.devops_mini_back.entity.Food;
import org.example.devops_mini_back.entity.FoodFavorite;
import org.example.devops_mini_back.service.FoodFavoriteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FoodFavoriteController {
    private final FoodFavoriteService foodFavoriteService;

    @GetMapping("/foodfavorites")
    public List<FoodFavoriteResponseDto> getAllFoodFavs() {
        return foodFavoriteService.getAllFoodFavorites()
                .stream()
                .map( o -> new FoodFavoriteResponseDto(
                        o.getFoodFavoriteId(),
                        o.getUser().getUserId(),
                        o.getFood().getFoodName(),
                        o.getFood().getKcal(),
                        o.getFood().getPicture()
                        )
                ).collect(Collectors.toList());
    }

    @GetMapping("/foodfavorites/{foodFavoriteId}")
    public FoodFavoriteResponseDto getFoodFav(@PathVariable("foodFavoriteId") int foodFavoriteId) {
        FoodFavorite target = foodFavoriteService.getFoodFavoriteById(foodFavoriteId);

        return new FoodFavoriteResponseDto(target.getFoodFavoriteId(),
                target.getUser().getUserId(), target.getFood().getFoodName(),
                target.getFood().getKcal(), target.getFood().getPicture());
    }

    @PostMapping("/foodfavorites")
    public FoodFavorite addFoodFav(@RequestBody FoodFavoriteCreateDto foodFavoriteCreateDto) {
        return foodFavoriteService.addFoodFavorite(foodFavoriteCreateDto);
    }

    @DeleteMapping("/foodfavorites/{foodFavoriteId}")
    public void deleteFoodFav(@PathVariable("foodFavoriteId") int foodFavoriteId) {
        foodFavoriteService.deleteFoodFavorite(foodFavoriteId);
    }
}