package org.example.devops_mini_back.controller;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.User.UserCreateDto;
import org.example.devops_mini_back.dto.User.UserUpdateDto;
import org.example.devops_mini_back.entity.User;
import org.example.devops_mini_back.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") int userId) {
        return userService.getUserById(userId);
    }
    @PostMapping
    public int addUser(@RequestBody UserCreateDto userCreateDto){
        int id = userService.addUser(userCreateDto);
        return id;
    }
    @PutMapping
    public void updateUser(@RequestBody UserUpdateDto userUpdateDto) {
        userService.updateUser(userUpdateDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
    }

}
