package org.example.devops_mini_back.controller;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.service.LoadExerciseListService;
import org.example.devops_mini_back.service.LoadFoodListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@RestController
@RequestMapping("/api/setfoodlist")
@RequiredArgsConstructor
public class SetFoodListController {
    private final LoadFoodListService loadFoodListService;

    @GetMapping
    public String LoadExerciseList(){
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url= "https://openapi.foodsafetykorea.go.kr/api/56dc2e604d314bc69bb3/COOKRCP01/json/1/1000";
            URI uri = new URI(url);
            String jsonResponse = restTemplate.getForObject(uri, String.class);
            boolean result= loadFoodListService.parseAndSaveJson(jsonResponse);
            return result?"successed":"already loaded";

    }catch (Exception e){
            e.printStackTrace();
            return "failed";
        }
}
}
