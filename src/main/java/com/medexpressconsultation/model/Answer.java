package com.medexpressconsultation.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Answer {

  private Long questionId;
  private Boolean answer; // null if unanswered

  public Answer() {
  }

  public Answer(Long questionId, Boolean answer) {
    this.questionId = questionId;
    this.answer = answer;
  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  public Boolean getAnswer() {
    return answer;
  }

  public void setAnswer(Boolean value) {
    this.answer = value;
  }

}