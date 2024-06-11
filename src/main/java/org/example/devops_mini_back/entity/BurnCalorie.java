package org.example.devops_mini_back.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class BurnCalorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int burnId;

    @Column(nullable = false, length = 10)
    private String date;

    @Column(nullable = false)
    private int calorie;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
