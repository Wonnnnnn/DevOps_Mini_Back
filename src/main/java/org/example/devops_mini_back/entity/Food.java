package org.example.devops_mini_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodId;
    @Column(length=45)
    private String foodName;
    private double kcal;
    private String picture;

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
