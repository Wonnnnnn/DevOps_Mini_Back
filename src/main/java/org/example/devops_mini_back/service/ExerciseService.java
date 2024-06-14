package org.example.devops_mini_back.service;


import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.Exercise.ExerciseCreateDto;
import org.example.devops_mini_back.dto.Exercise.ExerciseUpdateDto;
import org.example.devops_mini_back.entity.Exercise;
import org.example.devops_mini_back.exception.DuplicateNameException;
import org.example.devops_mini_back.exception.NoIdExistsException;
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
        IdExistCheck(id);
        return exerciseRepository.findById(id).get();
    }

    @Transactional
    public Exercise addExercise(ExerciseCreateDto exerciseCreateDto) {
        ExerciseNameCheck(exerciseCreateDto.getExerciseName());
        Exercise exercise = new Exercise(0,
                exerciseCreateDto.getExerciseName(), exerciseCreateDto.getKcal(),
                exerciseCreateDto.getYoutubeId(), exerciseCreateDto.getPicture());
        return exerciseRepository.save(exercise);
    }
    private void ExerciseNameCheck(String exerciseName) {
        if(exerciseRepository.existsByExerciseName(exerciseName)){
            throw new DuplicateNameException("이미 등록된 운동이 존재합니다.");
        }
    }

    @Transactional
    public Exercise updateExercise(ExerciseUpdateDto exerciseUpdateDto) {
        IdExistCheck(exerciseUpdateDto.getExerciseId());
        Exercise exercise = exerciseRepository.findById(exerciseUpdateDto.getExerciseId()).get();
        exercise.setYoutubeId(exerciseUpdateDto.getYoutubeId());
        exercise.setKcal(exerciseUpdateDto.getKcal());
        exercise.setPicture(exerciseUpdateDto.getPicture());
        return exerciseRepository.save(exercise);
    }

    @Transactional
    public void deleteExercise(int exerciseId) {
        IdExistCheck(exerciseId);
        exerciseRepository.deleteById(exerciseId);
    }

    public void IdExistCheck(int exerciseId) {
        if(!exerciseRepository.existsById(exerciseId)) {
            throw new NoIdExistsException("ID가 존재하지 않습니다.");
        }
    }
}
