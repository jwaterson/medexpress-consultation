package com.medexpressconsultation.mapper;

import com.medexpressconsultation.dto.ConsultationResultDTO;
import com.medexpressconsultation.model.ConsultationResult;
import org.springframework.stereotype.Component;

@Component
public class ConsultationResultDTOMapper implements
    DTOMapper<ConsultationResult, ConsultationResultDTO> {

  @Override
  public ConsultationResult toObject(ConsultationResultDTO dto) {
    return new ConsultationResult(dto);
  }

  @Override
  public ConsultationResultDTO toDTO(ConsultationResult consultationResult) {
    return new ConsultationResultDTO(consultationResult);
  }
}