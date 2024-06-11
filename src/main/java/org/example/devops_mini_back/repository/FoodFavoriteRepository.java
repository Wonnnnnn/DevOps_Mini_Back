package org.example.devops_mini_back.repository;

import org.example.devops_mini_back.entity.FoodFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodFavoriteRepository extends JpaRepository<FoodFavorite, Integer> {

public interface FoodFavoriteRepository extends JpaRepository<FoodFavorite,Integer> {
    void deleteAllByUser_UserId(int userID);
}
