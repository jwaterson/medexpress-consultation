package com.medexpressconsultation.dto;

import com.medexpressconsultation.model.Answer;
import com.medexpressconsultation.model.ConsultationResult;
import java.util.List;

public class ConsultationResultDTO {

  private final List<Answer> answers;

  public ConsultationResultDTO(ConsultationResult consultationResult) {
    this.answers = consultationResult.getAnswers();
  }

  public List<Answer> getAnswers() {
    return answers;
  }

}