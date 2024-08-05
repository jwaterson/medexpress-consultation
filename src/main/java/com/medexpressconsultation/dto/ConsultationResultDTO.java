package com.medexpressconsultation.dto;

import com.medexpressconsultation.model.Answer;
import com.medexpressconsultation.model.ConsultationResult;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultationResultDTO {

  private List<Answer> answers;
  private String prospectivePatientEmailAddress;
  private String prospectivePatientName;
  private Date timeSubmitted;

  /**
   * Required for jackson instantiation
   */
  @SuppressWarnings("unused")
  public ConsultationResultDTO() {
  }

  public ConsultationResultDTO(ConsultationResult consultationResult) {
    this.answers = consultationResult.getAnswers();
    this.prospectivePatientEmailAddress = consultationResult.getProspectivePatientEmailAddress();
    this.prospectivePatientName = consultationResult.getProspectivePatientName();
    this.timeSubmitted = consultationResult.getTimeSubmitted();
  }

}