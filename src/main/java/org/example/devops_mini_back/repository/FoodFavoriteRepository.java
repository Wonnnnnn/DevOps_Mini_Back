package org.example.devops_mini_back.repository;

<<<<<<< Updated upstream
import org.example.devops_mini_back.entity.FoodFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodFavoriteRepository extends JpaRepository<FoodFavorite, Integer> {
=======
import org.example.devops_mini_back.entity.BurnCalorie;
import org.example.devops_mini_back.entity.FoodFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodFavoriteRepository extends JpaRepository<FoodFavorite,Integer> {
    void deleteAllByUser_UserId(int userID);
>>>>>>> Stashed changes
}
