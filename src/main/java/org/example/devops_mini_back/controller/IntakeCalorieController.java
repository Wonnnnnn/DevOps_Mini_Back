package org.example.devops_mini_back.controller;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.IntakeCalorie.IntakeCalorieCreateDto;
import org.example.devops_mini_back.dto.IntakeCalorie.IntakeCalorieIdAndDateDto;
import org.example.devops_mini_back.entity.IntakeCalorie;
import org.example.devops_mini_back.service.IntakeCalorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/intakecalories")
@RequiredArgsConstructor
public class IntakeCalorieController {
    private final IntakeCalorieService intakeCalorieService;

    @GetMapping("/{userId}")
    public List<IntakeCalorie> getIntakebyuserId(@PathVariable("userId") int userId) {
        return intakeCalorieService.findByUserId(userId);
    }

    @GetMapping
    public IntakeCalorie getIntakeByUidAndDate(@RequestBody IntakeCalorieIdAndDateDto targetDto) {
        return intakeCalorieService.findByUserIdAndDate(targetDto);
    }

    @PostMapping
    public IntakeCalorie addBurnCalorie(@RequestBody IntakeCalorieCreateDto createDto) {
        return intakeCalorieService.addIntakeCalorie(createDto);
    }

    @DeleteMapping("/{intakeId}")
    public void deleteIntakeCalorie(@PathVariable("intakeId") int intakeId){
        intakeCalorieService.deleteIntakeCalorieById(intakeId);
    }

    @DeleteMapping
    public void deleteIntakeCalorieByUserIdAndDate(@RequestBody IntakeCalorieIdAndDateDto deleteDto){
        intakeCalorieService.deleteIntakeCalorieByIdAndDate(deleteDto);
    }
}
