package com.medexpressconsultation.dto;

import com.medexpressconsultation.model.Answer;
import com.medexpressconsultation.model.ConsultationResult;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultationResultDTO {

  private List<Answer> answers;

  /**
   * Required for jackson instantiation
   */
  public ConsultationResultDTO() {
  }

  public ConsultationResultDTO(ConsultationResult consultationResult) {
    this.answers = consultationResult.getAnswers();
  }

}