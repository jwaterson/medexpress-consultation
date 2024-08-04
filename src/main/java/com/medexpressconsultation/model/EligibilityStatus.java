package com.medexpressconsultation.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * An enumeration of possible eligibility statuses for a user seeking medication.
 */
@Getter
public enum EligibilityStatus {
  ELIGIBLE(true, "A doctor has reviewed your ou are eligible for medication."),
  INELIGIBLE(false, "You are not eligible for medication. Please consult your GP if you "
      + "have further questions."),
  UNDER_REVIEW(false, "You may be eligible for medication. A doctor is reviewing your "
      + "answers to determine your eligibility for medication. You should hear back shortly.");

  private final boolean eligible;
  @JsonValue
  private final String text;

  EligibilityStatus(boolean eligible, String text) {
    this.eligible = eligible;
    this.text = text;
  }

}