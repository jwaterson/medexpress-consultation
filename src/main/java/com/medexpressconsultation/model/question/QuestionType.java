package com.medexpressconsultation.model.question;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of question being asked, relative to consultation categories
 */
public enum QuestionType {
  AGREEMENT("Agreement"),
  MEDICAL_HISTORY("History"),
  CURRENT_MEDICATION("Medication"),
  CURRENT_SYMPTOMS("Symptoms"),
  CURRENT_HEALTH("Health");

  private final String type;

  QuestionType(String type) {
    this.type = type;
  }

  @JsonValue
  public String getType() {
    return type;
  }
}
