package org.example.devops_mini_back.repository;

import org.example.devops_mini_back.entity.ExerciseFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseFavoriteRepository extends JpaRepository<ExerciseFavorite, Integer> {
    void deleteAllByUser_UserId(int userID);
    List<ExerciseFavorite> findAllByUser_UserId(int userID);
}
