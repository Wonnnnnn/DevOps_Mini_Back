package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.Food.FoodCreateDto;
import org.example.devops_mini_back.dto.Food.FoodUpdateDto;
import org.example.devops_mini_back.entity.Food;
import org.example.devops_mini_back.exception.DuplicateNameException;
import org.example.devops_mini_back.exception.ValidationCheckException;
import org.example.devops_mini_back.repository.FoodRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        IdExistCheck(id);
        return foodRepository.findById(id).get();
    }

    @Transactional
    public Food addFood(FoodCreateDto foodCreateDto) {
        foodNameCheck(foodCreateDto.getFoodName());
        Food food = new Food(0, foodCreateDto.getFoodName(),
                foodCreateDto.getKcal(), foodCreateDto.getPicture());
        return foodRepository.save(food);
    }
    private void foodNameCheck(String foodName) {
        if(foodRepository.existsByFoodName(foodName)){
            throw new DuplicateNameException("이미 등록된 음식이 존재합니다.");
        }
    }

    @Transactional
    public Food updateFood(FoodUpdateDto foodUpdateDto) {
        IdExistCheck(foodUpdateDto.getFoodId());
        Food food = foodRepository.findById(foodUpdateDto.getFoodId()).get();
        food.setKcal(foodUpdateDto.getKcal());
        food.setPicture(foodUpdateDto.getPicture());
        return foodRepository.save(food);
    }

    @Transactional
    public void deleteFood(int foodId) {
        IdExistCheck(foodId);
        foodRepository.deleteById(foodId);
    }

    private void IdExistCheck(int foodId) {
        if(!foodRepository.existsById(foodId)) {
            throw new RuntimeException("ID가 존재하지 않습니다.");
        }
    }

}
