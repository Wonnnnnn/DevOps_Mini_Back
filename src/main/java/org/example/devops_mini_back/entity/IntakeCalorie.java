package org.example.devops_mini_back.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;

@Entity
@Getter
public class IntakeCalorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intakeId;

    @Column(nullable = false, length = 10)
    private Date date;

    @Column(nullable = false)
    private int breakfast;

    @Column(nullable = false)
    private int lunch;

    @Column(nullable = false)
    private int dinner;

    @Column(nullable = false)
    private int snack;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
