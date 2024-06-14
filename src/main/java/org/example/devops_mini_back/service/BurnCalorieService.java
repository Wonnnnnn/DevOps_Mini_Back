package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.BurnCalorie.BurnCalorieCreateDto;
import org.example.devops_mini_back.dto.BurnCalorie.BurnCalorieDeleteDto;
import org.example.devops_mini_back.dto.IntakeCalorie.IntakeCalorieCreateDto;
import org.example.devops_mini_back.entity.BurnCalorie;
import org.example.devops_mini_back.entity.IntakeCalorie;
import org.example.devops_mini_back.exception.ValidationCheckException;
import org.example.devops_mini_back.repository.BurnCalorieRepository;
import org.example.devops_mini_back.repository.UserRepository;
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

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BurnCalorieService {
    private final BurnCalorieRepository burnCalorieRepository;
    private final UserRepository userRepository;
    public List<BurnCalorie> getBurnCalorieByUser(int userId){
        return burnCalorieRepository.findByUser_UserId(userId);
    }
    public List<BurnCalorie> getAllBurnCalorie() {
        return burnCalorieRepository.findAll();
    }
    public BurnCalorie getBurnCalorieById(int id) {
        return burnCalorieRepository.findById(id).get();
    }
    public Optional<BurnCalorie> getBurnCalorieByIdAndDate(int userId, Date date){
        is_valid(date);
        return burnCalorieRepository.findByUser_UserIdAndDate(userId,date);
    }

    @Transactional
    public int addBurnCalorie(BurnCalorieCreateDto createDto) {
        is_valid(createDto.getDate());
        Optional<BurnCalorie> existBurn = existCheck(createDto);
        if (existBurn.isPresent()) {
            BurnCalorie burnCalorie = existBurn.get();
            burnCalorie.addBurnCalorie(createDto);
            burnCalorieRepository.save(burnCalorie);
            return burnCalorie.getBurnId();
        } else {
            BurnCalorie burnCalorie= new BurnCalorie(0,createDto.getDate(),createDto.getCalorie(),userRepository.findById(createDto.getUserId()).get());
            burnCalorieRepository.save(burnCalorie);
            return burnCalorie.getBurnId();
        }
    }


    private Optional<BurnCalorie> existCheck(BurnCalorieCreateDto createDto) {
        is_valid(createDto.getDate());
        return burnCalorieRepository.findByUser_UserIdAndDate(createDto.getUserId(), createDto.getDate());
    }

    @Transactional
    public void deleteBurnCalorieByUserId(int userId) {
        burnCalorieRepository.deleteAllByUser_UserId(userId);
    }
    @Transactional
    public void deleteBurnCalorieByUserAndDate(BurnCalorieDeleteDto deleteDto) {
        is_valid(deleteDto.getDate());
        burnCalorieRepository.deleteByUser_UserIdAndDate(deleteDto.getUserId(), deleteDto.getDate());
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
