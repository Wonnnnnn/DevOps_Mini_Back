package org.example.devops_mini_back.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CalorieDiagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int diagnosisId;

    private double monthUnit;

    private double goalKg;

    private double bmr;

    private double amr;

    private double tdee;

    private double eatNeeded;

    private double workoutNeeded;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
}
