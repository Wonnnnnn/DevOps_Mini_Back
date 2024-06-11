package org.example.devops_mini_back.repository;

import org.example.devops_mini_back.entity.BurnCalorie;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< Updated upstream
public interface BurnCalorieRepository extends JpaRepository<BurnCalorie, Integer> {
=======
import java.util.List;

public interface BurnCalorieRepository extends JpaRepository<BurnCalorie,Integer> {
    void deleteAllByUser_UserId(int userID);
>>>>>>> Stashed changes
}
