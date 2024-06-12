package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.IntakeCalorie.IntakeCalorieCreateDto;
import org.example.devops_mini_back.entity.IntakeCalorie;
import org.example.devops_mini_back.repository.IntakeCalorieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import org.example.devops_mini_back.repository.UserRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class IntakeCalorieService {
    private final IntakeCalorieRepository intakeCalorieRepository;
    private final UserRepository userRepository;

    public List<IntakeCalorie> findByUserId(int userId){
        return intakeCalorieRepository.findByUser_UserId(userId);
    }

    public List<IntakeCalorie> getAllIntakeCalorie() {
        return intakeCalorieRepository.findAll();
    }

    public IntakeCalorie getIntakeCalorieById(int id) {
        return intakeCalorieRepository.findById(id).get();
    }

    @Transactional
    public IntakeCalorie addIntakeCalorie(IntakeCalorieCreateDto intakeCalorieCreateDto) {
        IntakeCalorie intakeCalorie = new IntakeCalorie(0, intakeCalorieCreateDto.getDate(),
                intakeCalorieCreateDto.getBreakfast(), intakeCalorieCreateDto.getLunch(),
                intakeCalorieCreateDto.getDinner(), intakeCalorieCreateDto.getSnack(),
                userRepository.findById(intakeCalorieCreateDto.getUserId()).get()
        );
        return intakeCalorieRepository.save(intakeCalorie);
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

    @Transactional
    public void deleteIntakeCalorie(int intakeCalorieId) {
        intakeCalorieRepository.deleteById(intakeCalorieId);
    }

}