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

  private Answer answer1;
  private Answer answer2;
  private Answer answer3;
  private Answer answer4;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    answer1 = new Answer();
    answer1.setResponseRequiredForMedication(true);
    answer1.setYesNoValue(true);

    answer2 = new Answer();
    answer2.setResponseRequiredForMedication(null); // doesn't impact medication eligibility
    answer2.setYesNoValue(true);

    answer3 = new Answer();
    answer3.setResponseRequiredForMedication(true);
    answer3.setYesNoValue(false);

    answer4 = new Answer();
    answer4.setResponseRequiredForMedication(false);
    answer4.setYesNoValue(false);
  }

  @Test
  void testProcessConsultationResult() {
    List<Answer> answers = Arrays.asList(answer1, answer2);

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
    List<Answer> answers = Arrays.asList(answer1, answer2);

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
    consultationResult.setAnswers(List.of(answer3));

    consultationResultService.determineEligibility(consultationResult);

    assertEquals(EligibilityStatus.INELIGIBLE, consultationResult.getEligibilityStatus());
  }

  @Test
  void determineEligibility_responseRequiredDoesMatchYesNoValue_underReview() {
    ConsultationResult consultationResult = new ConsultationResult();
    consultationResult.setAnswers(List.of(answer4));

    consultationResultService.determineEligibility(consultationResult);

    assertEquals(EligibilityStatus.UNDER_REVIEW, consultationResult.getEligibilityStatus());
  }
}
