package org.example.devops_mini_back.controller;


import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.CalorieDiagnosis.CalorieDiagnosisUpdateDto;
import org.example.devops_mini_back.dto.User.UserUpdateDto;
import org.example.devops_mini_back.entity.CalorieDiagnosis;
import org.example.devops_mini_back.entity.User;
import org.example.devops_mini_back.repository.CalorieDiagnosisRepository;
import org.example.devops_mini_back.service.CalorieDiagnosisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/diagnosis")
@RequiredArgsConstructor
public class CalorieDiagnosisController {
    private final CalorieDiagnosisService calorieDiagnosisService;

    @GetMapping("/{userId}")
    public CalorieDiagnosis getDiagnosisById(@PathVariable("userId") int userId) {
        return calorieDiagnosisService.findByUserId(userId);
    }

    @PutMapping
    public void updateDiagnose(@RequestBody CalorieDiagnosisUpdateDto updateDto) {
        calorieDiagnosisService.updateCalorieDiagnosis(updateDto);
    }
}
