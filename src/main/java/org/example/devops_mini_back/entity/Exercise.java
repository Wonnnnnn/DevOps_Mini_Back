package org.example.devops_mini_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exerciseId;
    @Column(length=45)
    private String exerciseName;
    private double kcal;
    @Column(length=15)
    private String youtubeId;
    private String picture;

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
