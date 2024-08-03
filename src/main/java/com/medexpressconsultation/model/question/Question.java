package com.medexpressconsultation.model.question;

import com.medexpressconsultation.dto.QuestionDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * A question asked as part of a consultation.
 */
@Entity
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String text;
  @Enumerated
  private QuestionType type;
  private Long conditionId;

  public Question() {
  }

  public Question(String text, QuestionType type, Long conditionId) {
    this.text = text;
    this.type = type;
    this.conditionId = conditionId;
  }

  public Question(QuestionDTO dto) {
    this.text = dto.getText();
    this.type = QuestionType.valueOf(dto.getType());
    this.conditionId = dto.getConditionName();
  }

  public Long getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public QuestionType getType() {
    return type;
  }


  public Long getConditionId() {
    return conditionId;
  }
}