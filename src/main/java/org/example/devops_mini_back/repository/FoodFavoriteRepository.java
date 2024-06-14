package org.example.devops_mini_back.repository;

import org.example.devops_mini_back.dto.FoodFavorite.FoodFavoriteDeleteDto;
import org.example.devops_mini_back.entity.FoodFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodFavoriteRepository extends JpaRepository<FoodFavorite, Integer> {
    void deleteAllByUser_UserId(int userID);
    void deleteByUidandFoodId(FoodFavoriteDeleteDto foodFavoriteDeleteDto);
    List<FoodFavorite> findAllByUser_UserId(int userID);
}
