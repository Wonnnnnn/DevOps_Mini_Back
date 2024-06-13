package org.example.devops_mini_back.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.devops_mini_back.dto.User.UserCreateDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, unique = true, length = 10)
    private String id;

    @Column(nullable = false, length = 10)
    private String password;

    @Column(nullable = false, length = 3)
    private String name;

    @Column(columnDefinition = "int default 0")
    private double bmi;

    @OneToOne(fetch=FetchType.LAZY,mappedBy = "user")
    @JsonManagedReference
    @JsonIgnore
    private CalorieDiagnosis calorieDiagnosis;
    public static User newUser(UserCreateDto userCreateDto,CalorieDiagnosis calorieDiagnosis1) {
        return new User(0,userCreateDto.getId(),userCreateDto.getPassword(), userCreateDto.getUsername(),userCreateDto.getBmi(),calorieDiagnosis1);
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
}
