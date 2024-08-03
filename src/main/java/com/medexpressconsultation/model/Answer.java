package com.medexpressconsultation.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Embeddable
public class Answer {

  @Id
  @GeneratedValue
  private Long id;
  private Long questionId;
  private Boolean value; // null if unanswered

  public Answer() {
  }

  public Answer(Long questionId, Boolean value) {
    this.questionId = questionId;
    this.value = value;
  }

  public Long getId() {
    return id;
  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  public Boolean getValue() {
    return value;
  }

  public void setValue(Boolean value) {
    this.value = value;
  }
}
