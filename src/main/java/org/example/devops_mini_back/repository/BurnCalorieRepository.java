package org.example.devops_mini_back.repository;

import org.example.devops_mini_back.entity.BurnCalorie;
import org.example.devops_mini_back.entity.IntakeCalorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface BurnCalorieRepository extends JpaRepository<BurnCalorie, Integer> {
    void deleteAllByUser_UserId(int userID);
    List<BurnCalorie> findByUser_UserId(int userId);
    Optional<BurnCalorie> findByUser_UserIdAndDate(int userId, Date date);
    void deleteByUser_UserIdAndDate(int userID, Date date);
}
