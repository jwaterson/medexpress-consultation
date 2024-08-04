package com.medexpressconsultation.controller;

import com.medexpressconsultation.dto.ConsultationResultDTO;
import com.medexpressconsultation.dto.QuestionDTO;
import com.medexpressconsultation.model.ConsultationResult;
import com.medexpressconsultation.model.EligibilityStatus;
import com.medexpressconsultation.service.ConsultationResultService;
import com.medexpressconsultation.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

  private final QuestionService questionService;
  private final ConsultationResultService consultationResultService;

  @Autowired
  public ConsultationController(QuestionService questionService,
      ConsultationResultService consultationResultService) {
    this.questionService = questionService;
    this.consultationResultService = consultationResultService;
  }

  @GetMapping("/{conditionId}/questions")
  public ResponseEntity<List<QuestionDTO>> getQuestionsByConditionId(@PathVariable Long conditionId) {
    return new ResponseEntity<>(questionService.getQuestionsByConditionId(conditionId),
        HttpStatus.OK);
  }

  @PostMapping("/process")
  public ResponseEntity<EligibilityStatus> processConsultationResult(
      @RequestBody ConsultationResultDTO consultationResultDTO) {
    ConsultationResult consultationResult = consultationResultService.processConsultationResult(
        consultationResultDTO);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(consultationResult.getEligibilityStatus());
  }

}