package com.medexpressconsultation.mapper;

import com.medexpressconsultation.dto.QuestionDTO;
import com.medexpressconsultation.model.question.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionDTOMapper implements DTOMapper<Question, QuestionDTO> {

  @Override
  public Question toObject(QuestionDTO dto) {
    return new Question(dto);
  }

  @Override
  public QuestionDTO toDTO(Question question) {
    return new QuestionDTO(question);
  }

}