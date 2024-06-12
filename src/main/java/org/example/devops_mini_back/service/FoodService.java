package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.Food.FoodCreateDto;
import org.example.devops_mini_back.dto.Food.FoodUpdateDto;
import org.example.devops_mini_back.entity.Food;
import org.example.devops_mini_back.repository.FoodRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    public Food getFoodById(int id) {
        return foodRepository.findById(id).get();
    }

    @Transactional
    public Food addFood(FoodCreateDto foodCreateDto) {
        Food food = new Food(0, foodCreateDto.getFoodName(),
                foodCreateDto.getKcal(), foodCreateDto.getPicture());
        return foodRepository.save(food);
    }

    @Transactional
    public Food updateFood(FoodUpdateDto foodUpdateDto) {
        Food food = foodRepository.findById(foodUpdateDto.getFoodId()).get();
        food.setKcal(foodUpdateDto.getKcal());
        food.setPicture(foodUpdateDto.getPicture());
        return foodRepository.save(food);
    }

    @Transactional
    public void deleteFood(int foodId) {
        foodRepository.deleteById(foodId);
    }

}
