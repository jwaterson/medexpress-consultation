package com.medexpressconsultation.service;

import com.medexpressconsultation.dto.ConsultationResultDTO;
import com.medexpressconsultation.mapper.ConsultationResultDTOMapper;
import com.medexpressconsultation.model.ConsultationResult;
import com.medexpressconsultation.repository.ConsultationResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    consultationResultRepository.save(consultationResult);
    return consultationResult;
  }
}