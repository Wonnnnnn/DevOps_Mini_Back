package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.IntakeCalorie.IntakeCalorieCreateDto;
import org.example.devops_mini_back.dto.IntakeCalorie.IntakeCalorieIdAndDateDto;
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

    public IntakeCalorie findByUserIdAndDate(IntakeCalorieIdAndDateDto targetDto){
        return intakeCalorieRepository.findByUser_UserIdAndDate(targetDto.getUserId(), targetDto.getDate()).get();
    }

    public List<IntakeCalorie> getAllIntakeCalorie() {
        return intakeCalorieRepository.findAll();
    }

    public IntakeCalorie getIntakeCalorieById(int id) {
        return intakeCalorieRepository.findById(id).get();
    }

    @Transactional
    public IntakeCalorie addIntakeCalorie(IntakeCalorieCreateDto intakeCalorieCreateDto) {
        Optional<IntakeCalorie> existIntake = intakeCalorieRepository
                .findByUser_UserIdAndDate(intakeCalorieCreateDto.getUserId(), intakeCalorieCreateDto.getDate());

        if (existIntake.isPresent()) { //row 있을 시
            IntakeCalorie intakeCalorie = existIntake.get();

            if(intakeCalorie.getBreakfast() == 0) {
                intakeCalorie.setBreakfast(intakeCalorieCreateDto.getBreakfast());
            } else{
                if(intakeCalorieCreateDto.getBreakfast() != 0) {
                    intakeCalorie.setBreakfast(intakeCalorie.getBreakfast());
                }
            }

            if(intakeCalorie.getLunch() == 0) {
                intakeCalorie.setLunch(intakeCalorieCreateDto.getLunch());
            } else{
                if(intakeCalorieCreateDto.getLunch() != 0) {
                    intakeCalorie.setLunch(intakeCalorie.getLunch());
                }
            }

            if(intakeCalorie.getDinner() == 0) {
                intakeCalorie.setDinner(intakeCalorieCreateDto.getDinner());
            } else{
                if(intakeCalorieCreateDto.getDinner() != 0) {
                    intakeCalorie.setDinner(intakeCalorie.getDinner());
                }
            }

            if(intakeCalorie.getSnack() == 0) {
                intakeCalorie.setSnack(intakeCalorieCreateDto.getSnack());
            } else{
                if(intakeCalorieCreateDto.getSnack() != 0) {
                    intakeCalorie.setSnack(intakeCalorie.getSnack());
                }
            }

            return intakeCalorieRepository.save(intakeCalorie);

        } else { //row 없을 시
            IntakeCalorie makeintakeCalorie = new IntakeCalorie(
                    0, intakeCalorieCreateDto.getDate(),
                    intakeCalorieCreateDto.getBreakfast(), intakeCalorieCreateDto.getLunch(),
                    intakeCalorieCreateDto.getDinner(), intakeCalorieCreateDto.getSnack(),
                    userRepository.findById(intakeCalorieCreateDto.getUserId()).get()
            );

            return makeintakeCalorie;
        }
    }

    @Transactional
    public void deleteIntakeCalorieById(int intakeCalorieId) {
        intakeCalorieRepository.deleteById(intakeCalorieId);
    }

    @Transactional
    public void deleteIntakeCalorieByIdAndDate(IntakeCalorieIdAndDateDto intakeCalorieDeleteDto) {
        intakeCalorieRepository.deleteByUser_UserIdAndDate(intakeCalorieDeleteDto.getUserId(), intakeCalorieDeleteDto.getDate());
    }



}