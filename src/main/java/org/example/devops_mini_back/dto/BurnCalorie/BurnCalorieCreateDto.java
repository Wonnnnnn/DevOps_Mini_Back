package org.example.devops_mini_back.dto.BurnCalorie;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.devops_mini_back.entity.User;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BurnCalorieCreateDto {
    private Date date;
    private int calorie;
    private int userId;
}