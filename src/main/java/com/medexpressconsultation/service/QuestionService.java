package com.medexpressconsultation.service;

import com.medexpressconsultation.model.question.Question;
import com.medexpressconsultation.repository.ConditionRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

  private final ConditionRepository conditionRepository;

  public QuestionService(ConditionRepository conditionRepository) {
    this.conditionRepository = conditionRepository;
  }

  public List<Question> getConditionByName(String condition) {
    return conditionRepository
        .findByName(condition)
        .orElseThrow()
        .getQuestions();
  }

}
