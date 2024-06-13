package org.example.devops_mini_back.controller;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.ExerciseFavorite.ExerciseFavoriteCreateDto;
import org.example.devops_mini_back.dto.ExerciseFavorite.ExerciseFavoriteResponseDto;
import org.example.devops_mini_back.entity.ExerciseFavorite;
import org.example.devops_mini_back.service.ExerciseFavoriteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/exercisefavorites")
@RequiredArgsConstructor
public class ExerciseFavoriteController {
    private final ExerciseFavoriteService exerciseFavoriteService;

    @GetMapping
    public List<ExerciseFavoriteResponseDto> getAllExerciseFavs() {
        return exerciseFavoriteService.getAllExerciseFavorites()
                .stream()
                .map( o -> new ExerciseFavoriteResponseDto(
                                o.getExerciseFavoriteId(),
                                o.getUser().getUserId(),
                                o.getExercise().getExerciseName(),
                                o.getExercise().getYoutubeId(),
                                o.getExercise().getKcal(),
                                o.getExercise().getPicture()
                        )
                ).collect(Collectors.toList());
    }

    @GetMapping("/{exerciseFavoriteId}")
    public ExerciseFavoriteResponseDto getExerciseFav(@PathVariable("exerciseFavoriteId") int exerciseFavoriteId) {
        ExerciseFavorite target = exerciseFavoriteService.getExerciseFavoriteById(exerciseFavoriteId);

        return new ExerciseFavoriteResponseDto(target.getExerciseFavoriteId(),
                target.getUser().getUserId(), target.getExercise().getExerciseName(),
                target.getExercise().getYoutubeId(),target.getExercise().getKcal(),
                target.getExercise().getPicture());
    }

    @PostMapping
    public ExerciseFavorite addExerciseFav(@RequestBody ExerciseFavoriteCreateDto exerciseFavoriteCreateDto) {
        return exerciseFavoriteService.addExerciseFavorite(exerciseFavoriteCreateDto);
    }

    @DeleteMapping("/{exerciseFavoriteId}")
    public void deleteExerciseFav(@PathVariable("exerciseFavoriteId") int exerciseFavoriteId) {
        exerciseFavoriteService.deleteExerciseFavorite(exerciseFavoriteId);
    }
}
