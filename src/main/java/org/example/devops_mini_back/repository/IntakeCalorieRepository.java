package org.example.devops_mini_back.repository;

import org.example.devops_mini_back.entity.IntakeCalorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntakeCalorieRepository extends JpaRepository<IntakeCalorie, Integer> {
    void deleteAllByUser_UserId(int userID);
}
