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

  public Question() {
  }

  public Question(String text, QuestionType type) {
    this.text = text;
    this.type = type;
  }

  public Question(QuestionDTO dto) {
    this.text = dto.getText();
    this.type = QuestionType.valueOf(dto.getType());
  }

  public Long getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public QuestionType getType() {
    return type;
  }

  public void setType(QuestionType type) {
    this.type = type;
  }
}