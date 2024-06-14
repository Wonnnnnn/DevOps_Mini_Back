package org.example.devops_mini_back.controller;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.ExerciseFavorite.ExerciseFavoriteResponseDto;
import org.example.devops_mini_back.dto.FoodFavorite.FoodFavoriteCreateDto;
import org.example.devops_mini_back.dto.FoodFavorite.FoodFavoriteDeleteDto;
import org.example.devops_mini_back.dto.FoodFavorite.FoodFavoriteResponseDto;
import org.example.devops_mini_back.entity.FoodFavorite;
import org.example.devops_mini_back.service.FoodFavoriteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/foodfavorites")
@RequiredArgsConstructor
public class FoodFavoriteController {
    private final FoodFavoriteService foodFavoriteService;

    @GetMapping
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

    @GetMapping("/{userId}")
    public List<FoodFavoriteResponseDto> getAllFoodFavsUid(@PathVariable("userId") int userId) {
        return foodFavoriteService.getAllFoodFavoritesByUud(userId)
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

    @PostMapping
    public int addFoodFav(@RequestBody FoodFavoriteCreateDto foodFavoriteCreateDto) {
        return foodFavoriteService.addFoodFavorite(foodFavoriteCreateDto).getFoodFavoriteId();
    }

    @DeleteMapping
    public void deleteFoodFavsUidanFoodid(@RequestBody FoodFavoriteDeleteDto foodFavoriteDeleteDto) {
        foodFavoriteService.deleteFoodFavoriteUidandFoodId(foodFavoriteDeleteDto);
    }
}
