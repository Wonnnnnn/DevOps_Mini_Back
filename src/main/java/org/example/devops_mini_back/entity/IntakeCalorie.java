package org.example.devops_mini_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IntakeCalorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intakeId;

    @Column(nullable = false, length = 10)
    private Date date;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int breakfast;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int lunch;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int dinner;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int snack;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    public void setBreakfast(int breakfast) {
        this.breakfast = breakfast;
    }

    public void setLunch(int lunch) {
        this.lunch = lunch;
    }

    public void setDinner(int dinner) {
        this.dinner = dinner;
    }

    public void setSnack(int snack) {
        this.snack = snack;
    }
}
