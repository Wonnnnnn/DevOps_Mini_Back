package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.IntakeCalorie.IntakeCalorieCreateDto;
import org.example.devops_mini_back.dto.User.UserCreateDto;
import org.example.devops_mini_back.entity.CalorieDiagnosis;
import org.example.devops_mini_back.entity.IntakeCalorie;
import org.example.devops_mini_back.entity.User;
import org.example.devops_mini_back.exception.ValidationCheckException;
import org.example.devops_mini_back.repository.IntakeCalorieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class IntakeCalorieService {
    private final IntakeCalorieRepository intakeCalorieRepository;
    public IntakeCalorie findByUserId(int userId){
        return intakeCalorieRepository.findByUser_UserId(userId).get();
    }

    @Transactional
    public int addIntake(IntakeCalorieCreateDto createDto) {
        Optional<IntakeCalorie> existIntake = existCheck(createDto);
        if (existIntake.isPresent()) {
            IntakeCalorie intakeCalorie = existIntake.get();
        } else {

        }
        return 1;
    }


    private Optional<IntakeCalorie> existCheck(IntakeCalorieCreateDto createDto) {
        return intakeCalorieRepository.findByUser_UserIdAndDate(createDto.getUserId(), createDto.getDate());
    }



}
