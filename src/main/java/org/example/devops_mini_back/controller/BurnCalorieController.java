package org.example.devops_mini_back.controller;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.BurnCalorie.BurnCalorieCreateDto;
import org.example.devops_mini_back.dto.BurnCalorie.BurnCalorieDeleteDto;
import org.example.devops_mini_back.dto.CalorieDiagnosis.CalorieDiagnosisUpdateDto;
import org.example.devops_mini_back.entity.BurnCalorie;
import org.example.devops_mini_back.entity.CalorieDiagnosis;
import org.example.devops_mini_back.service.BurnCalorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/burncalorie")
@RequiredArgsConstructor
public class BurnCalorieController {
    private final BurnCalorieService burnCalorieService;

    @GetMapping("/{userId}")
    public List<BurnCalorie> getburnbyuserId(@PathVariable("userId") int userId) {
        return burnCalorieService.getBurnCalorieByUser(userId);
    }

    @PostMapping
    public int addBurnCalorie(@RequestBody BurnCalorieCreateDto createDto) {
        return burnCalorieService.addBurnCalorie(createDto);
    }

    @DeleteMapping("/{burnId}")
    public void deleteBurnCalorie(@PathVariable("burnId") int burnId){
        burnCalorieService.deleteBurnCalorie(burnId);
    }

    @DeleteMapping
    public void deleteBurnCalorieByUserIdAndDate(@RequestBody BurnCalorieDeleteDto deleteDto){
        burnCalorieService.deleteBurnCalorieByUserAndDate(deleteDto);
    }
}
