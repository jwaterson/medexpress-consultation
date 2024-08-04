package com.medexpressconsultation.service;

import com.medexpressconsultation.dto.QuestionDTO;
import com.medexpressconsultation.mapper.QuestionDTOMapper;
import com.medexpressconsultation.model.question.Question;
import com.medexpressconsultation.repository.QuestionRepository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class which handles {@link Question} entities.
 */
@Service
public class QuestionService {

  private final QuestionRepository questionRepository;
  private final QuestionDTOMapper questionMapper;

  @Autowired
  public QuestionService(QuestionRepository questionRepository, QuestionDTOMapper questionMapper) {
    this.questionRepository = questionRepository;
    this.questionMapper = questionMapper;
  }

  public List<QuestionDTO> getQuestionsByConditionId(Long conditionId) {
    return questionRepository
        .findByConditionId(conditionId)
        .orElseThrow()
        .stream()
        .map(questionMapper::toDTO)
        .sorted(Comparator.comparing(QuestionDTO::getOrdinal))
        .collect(Collectors.toList());
  }

}