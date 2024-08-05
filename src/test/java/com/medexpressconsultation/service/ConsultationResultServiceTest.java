package com.medexpressconsultation.service;

import com.medexpressconsultation.dto.ConsultationResultDTO;
import com.medexpressconsultation.mapper.ConsultationResultDTOMapper;
import com.medexpressconsultation.model.Answer;
import com.medexpressconsultation.model.ConsultationResult;
import com.medexpressconsultation.model.EligibilityStatus;
import com.medexpressconsultation.repository.ConsultationResultRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConsultationResultServiceTest {

  @Mock
  private ConsultationResultRepository consultationResultRepository;

  @Mock
  private ConsultationResultDTOMapper consultationResultMapper;

  @InjectMocks
  private ConsultationResultService consultationResultService;

  private Answer eligibleAnswer1;
  private Answer eligibleAnswer2;
  private Answer eligibleAnswer3;
  private Answer ineligibleAnswer1;
  private Answer ineligibleAnswer2;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    eligibleAnswer1 = new Answer();
    eligibleAnswer1.setResponseRequiredForMedication(true);
    eligibleAnswer1.setYesNoValue(true);

    eligibleAnswer2 = new Answer();
    eligibleAnswer2.setResponseRequiredForMedication(null); // doesn't impact medication eligibility
    eligibleAnswer2.setYesNoValue(true);

    eligibleAnswer3 = new Answer();
    eligibleAnswer3.setResponseRequiredForMedication(false);
    eligibleAnswer3.setYesNoValue(false);

    ineligibleAnswer1 = new Answer();
    ineligibleAnswer1.setResponseRequiredForMedication(true);
    ineligibleAnswer1.setYesNoValue(false);

    ineligibleAnswer2 = new Answer();
    ineligibleAnswer2.setResponseRequiredForMedication(true);
    ineligibleAnswer2.setYesNoValue(null);
  }

  @Test
  void processConsultationResult_dtoPassed_resultSavedAndConsultationResultReturned() {
    List<Answer> answers = Arrays.asList(eligibleAnswer1, eligibleAnswer2);

    ConsultationResult consultationResult = new ConsultationResult();
    consultationResult.setAnswers(answers);

    ConsultationResultDTO dto = new ConsultationResultDTO(consultationResult);

    when(consultationResultMapper.toObject(dto)).thenReturn(consultationResult);
    when(consultationResultRepository.save(any(ConsultationResult.class))).thenReturn(
        consultationResult);

    ConsultationResult result = consultationResultService.processConsultationResult(dto);

    assertNotNull(result);
    verify(consultationResultMapper, times(1)).toObject(dto);
    verify(consultationResultRepository, times(1)).save(consultationResult);
  }

  @Test
  void determineEligibility_responseRequiredNullOrMatchingYesNoValue_underReview() {
    List<Answer> answers = Arrays.asList(eligibleAnswer1, eligibleAnswer2);

    ConsultationResult consultationResult = new ConsultationResult();
    consultationResult.setAnswers(answers);

    ConsultationResultDTO dto = new ConsultationResultDTO(consultationResult);

    when(consultationResultMapper.toObject(dto)).thenReturn(consultationResult);

    consultationResultService.processConsultationResult(dto);
    consultationResultService.determineEligibility(consultationResult);

    assertEquals(EligibilityStatus.UNDER_REVIEW, consultationResult.getEligibilityStatus());
  }

  @Test
  void determineEligibility_responseRequiredDoesNotMatchYesNoValue_ineligible() {
    ConsultationResult consultationResult = new ConsultationResult();
    consultationResult.setAnswers(List.of(ineligibleAnswer1));

    consultationResultService.determineEligibility(consultationResult);

    assertEquals(EligibilityStatus.INELIGIBLE, consultationResult.getEligibilityStatus());
  }

  @Test
  void determineEligibility_responseRequiredDoesMatchYesNoValue_underReview() {
    ConsultationResult consultationResult = new ConsultationResult();
    consultationResult.setAnswers(List.of(eligibleAnswer3));

    consultationResultService.determineEligibility(consultationResult);

    assertEquals(EligibilityStatus.UNDER_REVIEW, consultationResult.getEligibilityStatus());
  }

  @Test
  void determineEligibility_yesNoValueNull_ineligible() {
    ConsultationResult consultationResult = new ConsultationResult();
    consultationResult.setAnswers(List.of(eligibleAnswer3, ineligibleAnswer2));

    consultationResultService.determineEligibility(consultationResult);

    assertEquals(EligibilityStatus.INELIGIBLE, consultationResult.getEligibilityStatus());
  }
}
