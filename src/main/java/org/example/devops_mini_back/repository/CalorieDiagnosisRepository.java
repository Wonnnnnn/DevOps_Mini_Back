package org.example.devops_mini_back.repository;

import org.example.devops_mini_back.entity.CalorieDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalorieDiagnosisRepository extends JpaRepository<CalorieDiagnosis, Integer> {
}
