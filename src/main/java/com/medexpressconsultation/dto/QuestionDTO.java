package com.medexpressconsultation.dto;

import com.medexpressconsultation.model.question.Question;

public class QuestionDTO {

  private final Long id;
  private final String text;
  private final String type;

  public QuestionDTO(Question question) {
    this.id = question.getId();
    this.text = question.getText();
    this.type = question.getType().getType();
  }

  public Long getId() {
    return id;
  }

  public String getText() {
    return text;
  }


  public String getType() {
    return type;
  }

}