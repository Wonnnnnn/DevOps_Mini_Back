package org.example.devops_mini_back.repository;

<<<<<<< Updated upstream
import org.example.devops_mini_back.entity.CalorieDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalorieDiagnosisRepository extends JpaRepository<CalorieDiagnosis, Integer> {
=======
import org.example.devops_mini_back.entity.BurnCalorie;
import org.example.devops_mini_back.entity.CalorieDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CalorieDiagnosisRepository extends JpaRepository<CalorieDiagnosis,Integer> {
    void deleteByUser_UserId(int userID);
>>>>>>> Stashed changes
}
