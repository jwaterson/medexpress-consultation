package com.medexpressconsultation.model;

import com.medexpressconsultation.dto.ConsultationResultDTO;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * The result of a consultation regarding a condition.
 */
@Getter
@Setter
@Entity
public class ConsultationResult {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ElementCollection
  @CollectionTable(name = "answer", joinColumns = @JoinColumn(name = "consultation_id"))
  private List<Answer> answers;
  @Enumerated
  private EligibilityStatus eligibilityStatus;

  /**
   * Required for jackson
   */
  public ConsultationResult() {
  }

  public ConsultationResult(ConsultationResultDTO consultationResultDTO) {
    this.answers = consultationResultDTO.getAnswers();
  }

}
