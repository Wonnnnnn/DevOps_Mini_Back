package org.example.devops_mini_back.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
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
}
