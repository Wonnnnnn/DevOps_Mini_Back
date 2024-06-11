package org.example.devops_mini_back.service;

import org.assertj.core.api.Assertions;
import org.example.devops_mini_back.dto.UserCreateDto;
import org.example.devops_mini_back.dto.UserUpdateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    void addUser() {
        int i = userService.addUser(new UserCreateDto("testid1", "password", "정명지", 25.01));
//
//        userService.updateUser(new UserUpdateDto(20.05,i));
//        Assertions.assertThat(userService.getUserById(i).getId()).isEqualTo("testid1");

    }
}