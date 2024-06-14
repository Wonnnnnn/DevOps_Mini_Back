package org.example.devops_mini_back.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.entity.Exercise;
import org.example.devops_mini_back.entity.Food;
import org.example.devops_mini_back.repository.ExerciseRepository;
import org.example.devops_mini_back.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class LoadFoodListService {
    private final FoodRepository foodRepository;
    public boolean parseAndSaveJson(String json) throws IOException {
        if(listexisted()){
            return false;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Map<String, Object>> jsonData = objectMapper.readValue(json, new TypeReference<Map<String, Map<String, Object>>>() {});

        // COOKRCP01 객체 가져오기
        Map<String, Object> cookRcp01 = jsonData.get("COOKRCP01");
        List<Map<String, String>> rowList = (List<Map<String, String>>) cookRcp01.get("row");

        for (Map<String, String> data : rowList) {
            double kcal=Double.parseDouble(data.get("INFO_ENG"));
            if(kcal>500){
                continue;
            }
            Food food= new Food(0,data.get("RCP_NM"),kcal,data.get("ATT_FILE_NO_MK"));
            foodRepository.save(food);
        }
        return true;
    }
    public boolean listexisted(){
        if(foodRepository.count()>100){
            return true;
        }
        return false;
    }

}
