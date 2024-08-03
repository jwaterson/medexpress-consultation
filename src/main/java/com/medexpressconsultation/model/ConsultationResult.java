package com.medexpressconsultation.model;

import com.medexpressconsultation.dto.ConsultationResultDTO;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class ConsultationResult {

  @Id
  @GeneratedValue
  private Long id;
  @ElementCollection
  private List<Answer> answers;
  private EligibilityStatus eligibilityStatus;

  public ConsultationResult() {
  }

  public ConsultationResult(ConsultationResultDTO consultationResultDTO) {
    this.answers = consultationResultDTO.getAnswers();
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public List<Answer> getAnswers() {
    return null;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }

  public EligibilityStatus getEligibilityStatus() {
    return eligibilityStatus;
  }
}
