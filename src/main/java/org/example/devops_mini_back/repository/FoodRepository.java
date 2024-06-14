package org.example.devops_mini_back.repository;

import org.example.devops_mini_back.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    boolean existsByFoodName(String name);
}
