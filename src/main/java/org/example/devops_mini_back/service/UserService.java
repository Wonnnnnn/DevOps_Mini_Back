package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.UserCreateDto;
import org.example.devops_mini_back.dto.UserUpdateDto;
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
        validationCheck(userCreateDto.getId());
        User user = User.newUser(userCreateDto);
        return userRepository.save(user).getUserId();
    }

    private void validationCheck(String newid) {
        List<String> errorMessages = new ArrayList<>();
        if(userRepository.existsById(newid)){
            errorMessages.add("이미 사용된 user ID 입니다.");
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
