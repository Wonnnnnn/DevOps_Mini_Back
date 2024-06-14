package org.example.devops_mini_back.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.entity.Exercise;
import org.example.devops_mini_back.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class LoadExerciseListService {
        private final ExerciseRepository exerciseRepository;
        public boolean parseAndSaveJson(String json) throws IOException {
            if(listexisted()){
                return false;
            }
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> responseMap = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
            List<Map<String, String>> dataList = (List<Map<String, String>>) responseMap.get("data");

            for (Map<String, String> data : dataList) {
                Exercise exercise = new Exercise(0,data.get("운동명"),Double.parseDouble(data.get("단위체중당에너지소비량"))
                ,null,null);
                exerciseRepository.save(exercise);
            }
            return true;
        }
        public boolean listexisted(){
            if(exerciseRepository.count()>100){
                return true;
            }
            return false;
        }

}
