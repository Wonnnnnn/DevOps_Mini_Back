package org.example.devops_mini_back.repository;
import org.example.devops_mini_back.entity.CalorieDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CalorieDiagnosisRepository extends JpaRepository<CalorieDiagnosis, Integer> {
    Optional<CalorieDiagnosis> findByUser_UserId(int userId);
    void deleteByUser_UserId(int userID);
}
