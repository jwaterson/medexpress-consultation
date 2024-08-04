package com.medexpressconsultation.model.question;

import com.medexpressconsultation.dto.QuestionDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * A question asked as part of a consultation.
 */
@Getter
@Setter
@Entity
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * A value used to determine the order in which Questions should be rendered for consultation
   */
  private int ordinal;
  private String text;
  @Enumerated
  private QuestionType questionType;
  private Boolean responseRequiredForMedication; // null indicates no particular response required
  private Long conditionId;

  public Question() {
  }

  public Question(int ordinal, String text, QuestionType questionType,
      boolean responseRequiredForMedication, Long conditionId) {
    this.ordinal = ordinal;
    this.text = text;
    this.questionType = questionType;
    this.responseRequiredForMedication = responseRequiredForMedication;
    this.conditionId = conditionId;
  }

  public Question(QuestionDTO dto) {
    this.ordinal = dto.getOrdinal();
    this.text = dto.getText();
    this.questionType = QuestionType.valueOf(dto.getQuestionType());
    this.responseRequiredForMedication = dto.getResponseRequiredForMedication();
    this.conditionId = dto.getConditionId();
  }

}