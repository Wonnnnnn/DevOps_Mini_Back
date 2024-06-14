package org.example.devops_mini_back.controller;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.service.LoadExerciseListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@RestController
@RequestMapping("/api/setexerciselist")
@RequiredArgsConstructor
public class SetExerciseListController {
    private final LoadExerciseListService loadExerciseListService;

    @GetMapping
    public String LoadExerciseList(){
        try {
            RestTemplate restTemplate = new RestTemplate();
            String key="vqBSOGYMpdHxZelwxgllWIalieyYPIBnN/XNc3vHLzOJckKsyG22cohzQMXw1oPh+VzhHMeaueWBZ5lMMoZ9hQ==";
            String encodedKey = URLEncoder.encode(key, StandardCharsets.UTF_8);
            String url= "https://api.odcloud.kr/api/15068730/v1/uddi:734ff9bb-3696-4993-a365-c0201eb0a6cd?perPage=360&serviceKey=";
            URI uri = new URI(url+encodedKey);
            String jsonResponse = restTemplate.getForObject(uri, String.class);
            boolean result=loadExerciseListService.parseAndSaveJson(jsonResponse);
            return result?"successed":"already loaded";

    }catch (Exception e){
            e.printStackTrace();
            return "failed";
        }
}
}
