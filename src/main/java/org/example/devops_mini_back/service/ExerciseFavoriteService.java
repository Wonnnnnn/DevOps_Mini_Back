package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.ExerciseFavorite.ExerciseFavoriteCreateDto;
import org.example.devops_mini_back.dto.ExerciseFavorite.ExerciseFavoriteDeleteDto;
import org.example.devops_mini_back.entity.ExerciseFavorite;
import org.example.devops_mini_back.exception.AlreadyExistException;
import org.example.devops_mini_back.repository.ExerciseFavoriteRepository;
import org.example.devops_mini_back.repository.FoodFavoriteRepository;
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
    private final FoodFavoriteRepository foodFavoriteRepository;

    public List<ExerciseFavorite> getAllExerciseFavorites() {
        return exerciseFavoriteRepository.findAll();
    }

    public List<ExerciseFavorite> getAllExerciseFavoritesByUid(int userId) {
        return exerciseFavoriteRepository.findAllByUser_UserId(userId);
    }


    @Transactional
    public ExerciseFavorite addExerciseFavorite(ExerciseFavoriteCreateDto exerciseFavoriteCreateDto) {
        isExistExerciseFavorite(exerciseFavoriteCreateDto.getUserId(), exerciseFavoriteCreateDto.getExerciseId());
        ExerciseFavorite exerciseFavorite = new ExerciseFavorite(0,
                userService.getUserById(exerciseFavoriteCreateDto.getUserId()),
                exerciseService.getExerciseById(exerciseFavoriteCreateDto.getExerciseId()));
        return exerciseFavoriteRepository.save(exerciseFavorite);
    }

    public void isExistExerciseFavorite(int favoriteId, int userid) {
        if(!exerciseFavoriteRepository.existsByUser_UserIdAndExercise_ExerciseId(userid,favoriteId)) {
            throw new AlreadyExistException("이미 등록된 운동입니다.");
        }
    }


    @Transactional
    public void deleteExerciseFavoriteByUidandExerciseId(ExerciseFavoriteDeleteDto exerciseFavoriteDeleteDto) {
        exerciseFavoriteRepository
                .deleteByUser_UserIdAndExerciseFavoriteId(
                        exerciseFavoriteDeleteDto.getUserId(),
                        exerciseFavoriteDeleteDto.getExerciseId());
    }
}
