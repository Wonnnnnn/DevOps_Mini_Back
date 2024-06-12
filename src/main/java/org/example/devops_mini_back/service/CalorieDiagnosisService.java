package org.example.devops_mini_back.service;

import lombok.RequiredArgsConstructor;
import org.example.devops_mini_back.dto.CalorieDiagnosis.CalorieDiagnosisUpdateDto;
import org.example.devops_mini_back.entity.CalorieDiagnosis;
import org.example.devops_mini_back.repository.CalorieDiagnosisRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CalorieDiagnosisService {
    private final CalorieDiagnosisRepository calorieDiagnosisRepository;
    public CalorieDiagnosis findByUserId(int userId){
        return calorieDiagnosisRepository.findByUser_UserId(userId).get();
    }
    @Transactional
    public void updateCalorieDiagnosis(CalorieDiagnosisUpdateDto updateDto ){
        CalorieDiagnosis diagnosis = calorieDiagnosisRepository.findByUser_UserId(updateDto.getUserId()).get();
        diagnosis.updateDiagnosis(updateDto);
        calorieDiagnosisRepository.save(diagnosis);
    }

}
