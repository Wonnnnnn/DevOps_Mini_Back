package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.BurnCalorie.BurnCalorieCreateDto;
import org.example.devops_mini_back.dto.BurnCalorie.BurnCalorieDeleteDto;
import org.example.devops_mini_back.dto.IntakeCalorie.IntakeCalorieCreateDto;
import org.example.devops_mini_back.entity.BurnCalorie;
import org.example.devops_mini_back.entity.IntakeCalorie;
import org.example.devops_mini_back.repository.BurnCalorieRepository;
import org.example.devops_mini_back.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
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
        return burnCalorieRepository.findByUser_UserIdAndDate(userId,date);
    }


    @Transactional
    public int addBurnCalorie(BurnCalorieCreateDto createDto) {
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
        return burnCalorieRepository.findByUser_UserIdAndDate(createDto.getUserId(), createDto.getDate());
    }

    @Transactional
    public void deleteBurnCalorie(int intakeCalorieId) {
        burnCalorieRepository.deleteById(intakeCalorieId);
    }
    @Transactional
    public void deleteBurnCalorieByUserAndDate(BurnCalorieDeleteDto deleteDto) {
        burnCalorieRepository.deleteByUser_UserIdAndDate(deleteDto.getUserId(), deleteDto.getDate());
    }
}
