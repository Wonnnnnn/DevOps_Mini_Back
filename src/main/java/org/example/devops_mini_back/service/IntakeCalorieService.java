package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.IntakeCalorie.IntakeCalorieCreateDto;
import org.example.devops_mini_back.dto.IntakeCalorie.IntakeCalorieIdAndDateDto;
import org.example.devops_mini_back.entity.IntakeCalorie;
import org.example.devops_mini_back.exception.ValidationCheckException;
import org.example.devops_mini_back.repository.IntakeCalorieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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
        is_valid(targetDto.getDate());
        return intakeCalorieRepository.findByUser_UserIdAndDate(targetDto.getUserId(), targetDto.getDate()).get();
    }

    @Transactional
    public IntakeCalorie addIntakeCalorie(IntakeCalorieCreateDto intakeCalorieCreateDto) {
        is_valid(intakeCalorieCreateDto.getDate());
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
    public void deleteIntakeCalorieByIdAndDate(IntakeCalorieIdAndDateDto intakeCalorieDeleteDto) {
        is_valid(intakeCalorieDeleteDto.getDate());
        intakeCalorieRepository.deleteByUser_UserIdAndDate(intakeCalorieDeleteDto.getUserId(), intakeCalorieDeleteDto.getDate());
    }

    @Transactional
    public void deleteIntakeCalorieByUid(int userId) {
        intakeCalorieRepository.deleteAllByUser_UserId(userId);
    }
    public void is_valid(Date date){
        List<String> errorMessages = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        LocalDateTime endOfDay = localDate.atTime(LocalTime.MAX);
        Timestamp timestamp = Timestamp.valueOf(endOfDay);
        Date today = new Date(timestamp.getTime());
        if(date.after(today)){
            errorMessages.add("미래의 날짜로 선택되었습니다.");
            throw new ValidationCheckException(errorMessages);
        }
    }


}