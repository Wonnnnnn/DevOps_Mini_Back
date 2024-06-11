package org.example.devops_mini_back.repository;

import org.example.devops_mini_back.entity.ExerciseFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseFavoriteRepository extends JpaRepository<ExerciseFavorite, Integer> {
}
