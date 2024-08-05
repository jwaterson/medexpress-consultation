package com.medexpressconsultation.service;

import com.medexpressconsultation.dto.ConsultationResultDTO;
import com.medexpressconsultation.mapper.ConsultationResultDTOMapper;
import com.medexpressconsultation.model.ConsultationResult;
import com.medexpressconsultation.model.EligibilityStatus;
import com.medexpressconsultation.repository.ConsultationResultRepository;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class which handles {@link ConsultationResult} entities.
 */
@Service
public class ConsultationResultService {

  private final ConsultationResultRepository consultationResultRepository;
  private final ConsultationResultDTOMapper consultationResultMapper;

  @Autowired
  public ConsultationResultService(ConsultationResultRepository consultationResultRepository,
      ConsultationResultDTOMapper consultationResultMapper) {
    this.consultationResultRepository = consultationResultRepository;
    this.consultationResultMapper = consultationResultMapper;
  }

  public ConsultationResult processConsultationResult(ConsultationResultDTO consultationResultDTO) {
    ConsultationResult consultationResult = consultationResultMapper.toObject(
        consultationResultDTO);
    determineEligibility(consultationResult);
    consultationResultRepository.save(consultationResult);
    return consultationResult;
  }

  /**
   * A method which stands as a placeholder for determining indicative eligibility for medication
   * (needs confirmation with a doctor following consultation). It is expected that indicative
   * eligibility would eventually be determined by more nuanced means and deliver a more
   * detailed eligibility status.
   *
   * @param consultationResult the consultation result whose eligibility needs determined
   */
  void determineEligibility(ConsultationResult consultationResult) {
    boolean eligible = consultationResult.getAnswers()
        .stream()
        // exclude from consideration those answers which do not impact medication eligibility
        .filter(answer -> Objects.nonNull(answer.getResponseRequiredForMedication()))
        .allMatch(
            answer -> answer.getResponseRequiredForMedication().equals(answer.getYesNoValue()));
    consultationResult.setEligibilityStatus(
        eligible ? EligibilityStatus.UNDER_REVIEW : EligibilityStatus.INELIGIBLE);
  }
}