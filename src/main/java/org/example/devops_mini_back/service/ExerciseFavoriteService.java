package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.ExerciseFavorite.ExerciseFavoriteCreateDto;
import org.example.devops_mini_back.entity.ExerciseFavorite;
import org.example.devops_mini_back.repository.ExerciseFavoriteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExerciseFavoriteService {
    private final ExerciseFavoriteRepository exerciseFavoriteRepository;
    private final ExerciseService exerciseService;
    private final UserService userService;

    public List<ExerciseFavorite> getAllExerciseFavorites() {
        return exerciseFavoriteRepository.findAll();
    }

    public ExerciseFavorite getExerciseFavoriteById(int id) {
        return exerciseFavoriteRepository.findById(id).get();
    }

    @Transactional
    public ExerciseFavorite addExerciseFavorite(ExerciseFavoriteCreateDto exerciseFavoriteCreateDto) {
        ExerciseFavorite exerciseFavorite = new ExerciseFavorite(0, userService.getUserById(exerciseFavoriteCreateDto.getUserId()), exerciseService.getExerciseById(exerciseFavoriteCreateDto.getExerciseId()));
        return exerciseFavoriteRepository.save(exerciseFavorite);
    }

    @Transactional
    public void deleteExerciseFavorite(int foodId) {
        exerciseFavoriteRepository.deleteById(foodId);
    }
}
