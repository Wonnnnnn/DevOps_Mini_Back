package org.example.devops_mini_back.repository;

import org.example.devops_mini_back.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
}
