package org.example.devops_mini_back.controller;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.IntakeCalorie.IntakeCalorieCreateDto;
import org.example.devops_mini_back.dto.IntakeCalorie.IntakeCalorieIdAndDateDto;
import org.example.devops_mini_back.dto.IntakeCalorie.IntakeCalorieResponseDto;
import org.example.devops_mini_back.entity.IntakeCalorie;
import org.example.devops_mini_back.service.IntakeCalorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/intakecalories")
@RequiredArgsConstructor
public class IntakeCalorieController {
    private final IntakeCalorieService intakeCalorieService;

    @GetMapping
    public List<IntakeCalorieResponseDto> getAllIntake() {
        return intakeCalorieService.getAllIntakeCalorie()
                .stream()
                .map( o -> new IntakeCalorieResponseDto(
                                o.getDate(),
                                o.getUser().getUserId(),
                                o.getBreakfast(),
                                o.getLunch(),
                                o.getDinner(),
                                o.getSnack()
                        )
                ).collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public List<IntakeCalorieResponseDto> getIntakebyuserId(@PathVariable("userId") int userId) {
        return intakeCalorieService.findByUserId(userId)
                .stream()
                .map( o -> new IntakeCalorieResponseDto(
                                o.getDate(),
                                o.getUser().getUserId(),
                                o.getBreakfast(),
                                o.getLunch(),
                                o.getDinner(),
                                o.getSnack()
                        )
                ).collect(Collectors.toList());
    }

    @GetMapping("/UidAndDate")
    public IntakeCalorieResponseDto getIntakeByUidAndDate(@RequestBody IntakeCalorieIdAndDateDto targetDto) {
        IntakeCalorie resp = intakeCalorieService.findByUserIdAndDate(targetDto);

        return new IntakeCalorieResponseDto(
                resp.getDate(), resp.getUser().getUserId(),
                resp.getBreakfast(), resp.getLunch(),
                resp.getDinner(), resp.getSnack()
        );
    }

    @PostMapping
    public IntakeCalorieResponseDto addBurnCalorie(@RequestBody IntakeCalorieCreateDto createDto) {
        IntakeCalorie resp = intakeCalorieService.addIntakeCalorie(createDto);

        return new IntakeCalorieResponseDto(
                resp.getDate(), resp.getUser().getUserId(),
                resp.getBreakfast(), resp.getLunch(),
                resp.getDinner(), resp.getSnack()
        );
    }

    @DeleteMapping("/{intakeId}")
    public void deleteIntakeCalorie(@PathVariable("intakeId") int intakeId){
        intakeCalorieService.deleteIntakeCalorieById(intakeId);
    }

    @DeleteMapping("/{userId}")
    public void deleteIntakeCalorieByUserId(@PathVariable("userId") int userId){
        intakeCalorieService.deleteIntakeCalorieByUid(userId);
    }

    @DeleteMapping
    public void deleteIntakeCalorieByUserIdAndDate(@RequestBody IntakeCalorieIdAndDateDto deleteDto){
        intakeCalorieService.deleteIntakeCalorieByIdAndDate(deleteDto);
    }
}
