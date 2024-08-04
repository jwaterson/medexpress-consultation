package com.medexpressconsultation.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * An enumeration of possible eligibility statuses for a user seeking medication.
 */
@Getter
public enum EligibilityStatus {
  ELIGIBLE(true, """
      A doctor has reviewed the answers you provided and has judged that you are eligible for \
      medication."""),
  INELIGIBLE(false, """
      Based on the answers you have provided, you are not eligible for medication. Please consult \
      your GP for further advice."""),
  UNDER_REVIEW(false, """
      Based on the answers you have provided, you may be eligible for medication. A doctor is \
      reviewing your answers to confirm your eligibility. You should hear back shortly by email.""");

  private final boolean eligible;
  @JsonValue
  private final String text;

  EligibilityStatus(boolean eligible, String text) {
    this.eligible = eligible;
    this.text = text;
  }

}