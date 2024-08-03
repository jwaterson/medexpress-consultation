package com.medexpressconsultation.service;

import com.medexpressconsultation.dto.QuestionDTO;
import com.medexpressconsultation.mapper.QuestionDTOMapper;
import com.medexpressconsultation.repository.ConditionRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

  private final ConditionRepository conditionRepository;
  private final QuestionDTOMapper questionMapper;

  @Autowired
  public QuestionService(ConditionRepository conditionRepository, QuestionDTOMapper questionMapper) {
    this.conditionRepository = conditionRepository;
    this.questionMapper = questionMapper;
  }

  public List<QuestionDTO> getQuestionsByConditionName(String condition) {
    return conditionRepository
        .findByName(condition)
        .orElseThrow()
        .getQuestions()
        .stream()
        .map(questionMapper::toDTO)
        .collect(Collectors.toList());
  }

}