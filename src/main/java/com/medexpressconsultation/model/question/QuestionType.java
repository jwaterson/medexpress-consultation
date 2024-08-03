package com.medexpressconsultation.model.question;

import com.fasterxml.jackson.annotation.JsonValue;

public enum QuestionType {
  DISCLAIMERS("Disclaimers"),
  MEDICAL_HISTORY("History"),
  CURRENT_SYMPTOMS("Symptoms"),
  GENERAL("General");

  private final String type;

  QuestionType(String type) {
    this.type = type;
  }

  @JsonValue
  public String getType() {
    return type;
  }
}
