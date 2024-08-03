package com.medexpressconsultation.model.question;

import com.medexpressconsultation.dto.QuestionDTO;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * A question asked as part of a consultation.
 */
@Embeddable
public class Question {

  @Id
  @GeneratedValue
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
