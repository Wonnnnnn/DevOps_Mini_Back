package org.example.devops_mini_back.repository;

<<<<<<< Updated upstream
import org.example.devops_mini_back.entity.ExerciseFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseFavoriteRepository extends JpaRepository<ExerciseFavorite, Integer> {
=======
import org.example.devops_mini_back.entity.BurnCalorie;
import org.example.devops_mini_back.entity.ExerciseFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseFavoriteRepository extends JpaRepository<ExerciseFavorite,Integer> {
    void deleteAllByUser_UserId(int userID);
>>>>>>> Stashed changes
}
