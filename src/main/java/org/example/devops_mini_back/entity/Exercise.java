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
    private int kcal;
    private int youtubeId;
    private String picture;

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public void setYoutubeId(int youtubeId) {
        this.youtubeId = youtubeId;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
