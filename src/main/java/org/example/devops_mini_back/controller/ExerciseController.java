package org.example.devops_mini_back.controller;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.Exercise.ExerciseCreateDto;
import org.example.devops_mini_back.dto.Exercise.ExerciseUpdateDto;
import org.example.devops_mini_back.entity.Exercise;
import org.example.devops_mini_back.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping("/exercises")
    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @GetMapping("/exercises/{exerciseId}")
    public Exercise getExercise(@PathVariable("exerciseId") int exerciseId) {
        return exerciseService.getExerciseById(exerciseId);
    }

    @PostMapping("/exercises")
    public Exercise addExercise(@RequestBody ExerciseCreateDto exerciseCreateDto) {
        return exerciseService.addExercise(exerciseCreateDto);
    }

    @PostMapping("/exercises/update")
    public Exercise updateExercise(@RequestBody ExerciseUpdateDto exerciseUpdateDto) {
        return exerciseService.updateExercise(exerciseUpdateDto);
    }

    @DeleteMapping("/exercises/{exerciseId}")
    public void deleteFood(@PathVariable("exerciseId") int exerciseId) {
        exerciseService.deleteExercise(exerciseId);
    }
}
