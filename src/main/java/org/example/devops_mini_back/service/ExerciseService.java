package org.example.devops_mini_back.service;


import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.Exercise.ExerciseCreateDto;
import org.example.devops_mini_back.dto.Exercise.ExerciseUpdateDto;
import org.example.devops_mini_back.entity.Exercise;
import org.example.devops_mini_back.repository.ExerciseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise getExerciseById(int id) {
        return exerciseRepository.findById(id).get();
    }

    @Transactional
    public Exercise addExercise(ExerciseCreateDto exerciseCreateDto) {
        Exercise exercise = new Exercise(0,
                exerciseCreateDto.getExerciseName(), exerciseCreateDto.getKcal(),
                exerciseCreateDto.getYoutubeId(), exerciseCreateDto.getPicture());
        return exerciseRepository.save(exercise);
    }

    @Transactional
    public Exercise updateExercise(ExerciseUpdateDto exerciseUpdateDto) {
        Exercise exercise = exerciseRepository.findById(exerciseUpdateDto.getExerciseId()).get();
        exercise.setYoutubeId(exerciseUpdateDto.getYoutubeId());
        exercise.setKcal(exerciseUpdateDto.getKcal());
        exercise.setPicture(exerciseUpdateDto.getPicture());
        return exerciseRepository.save(exercise);
    }

    @Transactional
    public void deleteExercise(int exerciseId) {
        exerciseRepository.deleteById(exerciseId);
    }
}
