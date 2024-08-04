package com.medexpressconsultation.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

/**
 * An answer given as part of a consultation
 */
@Getter
@Setter
@Embeddable
public class Answer {

  private Long questionId;
  private Boolean responseRequiredForMedication;
  private Boolean yesNoValue;
  private String text;

  /**
   * Required for jackson instantiation
   */
  public Answer() {
  }

}