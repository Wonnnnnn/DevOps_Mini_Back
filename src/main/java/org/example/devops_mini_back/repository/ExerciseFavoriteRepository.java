package org.example.devops_mini_back.repository;

import org.example.devops_mini_back.dto.ExerciseFavorite.ExerciseFavoriteDeleteDto;
import org.example.devops_mini_back.entity.ExerciseFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseFavoriteRepository extends JpaRepository<ExerciseFavorite, Integer> {
    void deleteAllByUser_UserId(int userID);
    void deleteByUser_UserIdAndExerciseFavoriteId(int user_userId, int exerciseFavoriteId);
    List<ExerciseFavorite> findAllByUser_UserId(int userID);
}
