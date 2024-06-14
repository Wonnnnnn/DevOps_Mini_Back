package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.FoodFavorite.FoodFavoriteCreateDto;
import org.example.devops_mini_back.dto.FoodFavorite.FoodFavoriteDeleteDto;
import org.example.devops_mini_back.entity.FoodFavorite;
import org.example.devops_mini_back.exception.AlreadyExistException;
import org.example.devops_mini_back.repository.FoodFavoriteRepository;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
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
    private final ThreadPoolTaskExecutorBuilder threadPoolTaskExecutorBuilder;

    public List<FoodFavorite> getAllFoodFavorites() {
        return foodFavoriteRepository.findAll();
    }

    public List<FoodFavorite> getAllFoodFavoritesByUud(int userid) {
        return foodFavoriteRepository.findAllByUser_UserId(userid);
    }

    @Transactional
    public FoodFavorite addFoodFavorite(FoodFavoriteCreateDto foodFavoriteCreateDto) {
        isExistFoodFavorite(foodFavoriteCreateDto.getUserId(), foodFavoriteCreateDto.getFoodId());
        FoodFavorite foodFavorite = new FoodFavorite(0,
                userService.getUserById(foodFavoriteCreateDto.getUserId()),
                foodService.getFoodById(foodFavoriteCreateDto.getFoodId()));
        return foodFavoriteRepository.save(foodFavorite);
    }

    public void isExistFoodFavorite(int favoriteId, int userid) {
        if(!foodFavoriteRepository.existsByUser_UserIdAndFood_FoodId(userid,favoriteId)) {
            throw new AlreadyExistException("이미 등록된 음식입니다.");
        }
    }

    @Transactional
    public void deleteFoodFavoriteUidandFoodId(FoodFavoriteDeleteDto foodFavoriteDeleteDto) {
        foodFavoriteRepository
                .deleteByUser_UserIdAndFoodFavoriteId(
                        foodFavoriteDeleteDto.getUserId(),
                        foodFavoriteDeleteDto.getFoodId());
    }
}
