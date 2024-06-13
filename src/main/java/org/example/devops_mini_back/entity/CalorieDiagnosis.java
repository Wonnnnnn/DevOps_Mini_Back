package org.example.devops_mini_back.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import org.example.devops_mini_back.dto.CalorieDiagnosis.CalorieDiagnosisUpdateDto;

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

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    @JsonBackReference
    @JsonIgnore
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public void updateDiagnosis(CalorieDiagnosisUpdateDto updateDto) {

        this.monthUnit=updateDto.getMonthUnit();
        this.goalKg=updateDto.getGoalKg();
        this.bmr= updateDto.getBmr();
        this.amr= updateDto.getAmr();
        this.tdee=updateDto.getTdee();
        this.eatNeeded= updateDto.getEatNeeded();
        this.workoutNeeded= updateDto.getWorkoutNeeded();
    }
}
