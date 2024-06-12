package org.example.devops_mini_back.controller;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.Exercise.ExerciseCreateDto;
import org.example.devops_mini_back.dto.Exercise.ExerciseUpdateDto;
import org.example.devops_mini_back.entity.Exercise;
import org.example.devops_mini_back.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping
    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @GetMapping("/{exerciseId}")
    public Exercise getExercise(@PathVariable("exerciseId") int exerciseId) {
        return exerciseService.getExerciseById(exerciseId);
    }

    @PostMapping
    public Exercise addExercise(@RequestBody ExerciseCreateDto exerciseCreateDto) {
        return exerciseService.addExercise(exerciseCreateDto);
    }

    @PutMapping
    public Exercise updateExercise(@RequestBody ExerciseUpdateDto exerciseUpdateDto) {
        return exerciseService.updateExercise(exerciseUpdateDto);
    }

    @DeleteMapping("/{exerciseId}")
    public void deleteFood(@PathVariable("exerciseId") int exerciseId) {
        exerciseService.deleteExercise(exerciseId);
    }
}
