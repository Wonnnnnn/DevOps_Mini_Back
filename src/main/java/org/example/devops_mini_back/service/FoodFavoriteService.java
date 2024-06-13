package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.FoodFavorite.FoodFavoriteCreateDto;
import org.example.devops_mini_back.entity.FoodFavorite;
import org.example.devops_mini_back.repository.FoodFavoriteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FoodFavoriteService {
    private final FoodFavoriteRepository foodFavoriteRepository;
    private final FoodService foodService;
    private final UserService userService;

    public List<FoodFavorite> getAllFoodFavorites() {
        return foodFavoriteRepository.findAll();
    }

    public List<FoodFavorite> getAllFoodFavoritesByUud(int userid) {
        return foodFavoriteRepository.findAllByUser_UserId(userid);
    }

    public FoodFavorite getFoodFavoriteById(int id) {
        return foodFavoriteRepository.findById(id).get();
    }

    @Transactional
    public FoodFavorite addFoodFavorite(FoodFavoriteCreateDto foodFavoriteCreateDto) {
        FoodFavorite foodFavorite = new FoodFavorite(0,
                userService.getUserById(foodFavoriteCreateDto.getUserId()),
                foodService.getFoodById(foodFavoriteCreateDto.getFoodId()));
        return foodFavoriteRepository.save(foodFavorite);
    }

    @Transactional
    public void deleteFoodFavorite(int foodId) {
        foodFavoriteRepository.deleteById(foodId);
    }
}
