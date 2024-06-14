package org.example.devops_mini_back.controller;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.BurnCalorie.BurnCalorieCreateDto;
import org.example.devops_mini_back.dto.BurnCalorie.BurnCalorieDeleteDto;
import org.example.devops_mini_back.dto.CalorieDiagnosis.CalorieDiagnosisUpdateDto;
import org.example.devops_mini_back.entity.BurnCalorie;
import org.example.devops_mini_back.entity.CalorieDiagnosis;
import org.example.devops_mini_back.service.BurnCalorieService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/burncalorie")
@RequiredArgsConstructor
public class BurnCalorieController {
    private final BurnCalorieService burnCalorieService;

    @GetMapping("/{userId}")
    public List<BurnCalorie> getburnbyuserId(@PathVariable("userId") int userId) {
        return burnCalorieService.getBurnCalorieByUser(userId);
    }
    @GetMapping("/{userId}/{date}")
    public BurnCalorie getburnbyuserIdDate(@PathVariable("userId") int userId, @PathVariable("date") Date date) {
        return burnCalorieService.getBurnCalorieByIdAndDate(userId,date).get();
    }

    @PostMapping
    public int addBurnCalorie(@RequestBody BurnCalorieCreateDto createDto) {
        return burnCalorieService.addBurnCalorie(createDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteBurnCalorieByUserId(@PathVariable("userId") int userId){
        burnCalorieService.deleteBurnCalorieByUserId(userId);
    }

    @DeleteMapping
    public void deleteBurnCalorieByUserIdAndDate(@RequestBody BurnCalorieDeleteDto deleteDto){
        burnCalorieService.deleteBurnCalorieByUserAndDate(deleteDto);
    }

}
