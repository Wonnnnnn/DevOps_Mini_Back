package org.example.devops_mini_back.repository;

import org.example.devops_mini_back.entity.CalorieDiagnosis;
import org.example.devops_mini_back.entity.IntakeCalorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface IntakeCalorieRepository extends JpaRepository<IntakeCalorie, Integer> {
    List<IntakeCalorie> findByUser_UserId(int userId);
    Optional<IntakeCalorie> findByUser_UserIdAndDate(int userId, Date date);
    void deleteAllByUser_UserId(int userID);
}
