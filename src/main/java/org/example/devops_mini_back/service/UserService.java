package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.User.UserCreateDto;
import org.example.devops_mini_back.dto.User.UserUpdateDto;
import org.example.devops_mini_back.entity.CalorieDiagnosis;
import org.example.devops_mini_back.entity.Response;
import org.example.devops_mini_back.entity.User;
import org.example.devops_mini_back.exception.ValidationCheckException;
import org.example.devops_mini_back.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BurnCalorieRepository burnCalorieRepository;
    private final CalorieDiagnosisRepository calorieDiagnosisRepository;
    private final ExerciseFavoriteRepository exerciseFavoriteRepository;
    private final FoodFavoriteRepository foodFavoriteRepository;
    private final IntakeCalorieRepository intakeCalorieRepository;


    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserById(int userId){
        return userRepository.findById(userId).get();
    }
    @Transactional
    public int addUser(UserCreateDto userCreateDto){
        validationCheck(userCreateDto);
        CalorieDiagnosis calorieDiagnosis=new CalorieDiagnosis();
        User user = User.newUser(userCreateDto,calorieDiagnosis);
        calorieDiagnosis.setUser(user);
        calorieDiagnosisRepository.save(calorieDiagnosis);
        return user.getUserId();
    }



    private void validationCheck(UserCreateDto userCreateDto){
        List<String> errorMessages = new ArrayList<>();
        if(userRepository.existsById(userCreateDto.getId())) {
            errorMessages.add("이미 사용된 user ID 입니다.");
        }
        if(userCreateDto.getUsername().length()>10){
            errorMessages.add("사용자 이름은 최대 10자리입니다.");
        }
        if(userCreateDto.getPassword().length()>10){
            errorMessages.add("사용자 비밀번호는 최대 10자리입니다.");
        }
        if(userCreateDto.getBmi()<0){
            errorMessages.add("bmi는 음수일 수 없습니다.");
        }
        if (!errorMessages.isEmpty()) {
            throw new ValidationCheckException(errorMessages);
        }

    }

    @Transactional
    public void updateUser(UserUpdateDto userUpdateDto){
        User user=userRepository.findById(userUpdateDto.getUserId()).get();
        user.setBmi(userUpdateDto.getBmi());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(int userId){
        userRepository.deleteById(userId);
        burnCalorieRepository.deleteAllByUser_UserId(userId);
        calorieDiagnosisRepository.deleteByUser_UserId(userId);
        exerciseFavoriteRepository.deleteAllByUser_UserId(userId);
        foodFavoriteRepository.deleteAllByUser_UserId(userId);
        intakeCalorieRepository.deleteAllByUser_UserId(userId);
    }

}
