package org.example.devops_mini_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.devops_mini_back.dto.UserCreateDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, unique = true, length = 10)
    private String id;

    @Column(nullable = false, length = 10)
    private String password;

    @Column(nullable = false, length = 3)
    private String name;

    private double bmi;

    public static User newUser(UserCreateDto userCreateDto) {
        return new User(0,userCreateDto.getId(),userCreateDto.getPassword(), userCreateDto.getUsername(),userCreateDto.getBmi());
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
}
