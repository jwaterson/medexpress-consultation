package com.medexpressconsultation.dto;

import com.medexpressconsultation.model.question.Question;
import lombok.Getter;

@Getter
public class QuestionDTO {

  private final Long id;
  private final int ordinal;
  private final String text;
  private final String questionType;
  private final Long conditionId;
  private final Boolean responseRequiredForMedication;

  public QuestionDTO(Question question) {
    this.id = question.getId();
    this.ordinal = question.getOrdinal();
    this.text = question.getText();
    this.questionType = question.getQuestionType().getType();
    this.responseRequiredForMedication = question.getResponseRequiredForMedication();
    this.conditionId = question.getConditionId();

  }

}