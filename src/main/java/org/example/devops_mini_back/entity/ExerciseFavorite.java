package org.example.devops_mini_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseFavorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exerciseFavoriteId;
    private int userId;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="exercise_id")
    private Exercise exercise;
}
