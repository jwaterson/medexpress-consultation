package com.medexpressconsultation.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class EligibilityStatus {
  private boolean eligible;
  private String reasonText;


  public static EligibilityStatus forConsultationResult(
      ConsultationResult consultationResult) {
    return null;
  }
}