package org.example.devops_mini_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.devops_mini_back.dto.BurnCalorie.BurnCalorieCreateDto;

import java.sql.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BurnCalorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int burnId;

    @Column(nullable = false, length = 10)
    private Date date;

    @Column(nullable = false)
    private double calorie;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    public void addBurnCalorie(BurnCalorieCreateDto createDto) {
        this.calorie += createDto.getCalorie();
    }
}
