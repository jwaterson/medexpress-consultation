package com.medexpressconsultation.controller;

import com.medexpressconsultation.model.question.Question;
import com.medexpressconsultation.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {

  private final QuestionService questionService;

  @Autowired
  public ConsultationController(QuestionService questionService) {
    this.questionService = questionService;
  }

  @GetMapping("/{condition}/questions")
  public List<Question> getQuestionsByCondition(@PathVariable String condition) {
    return questionService.getConditionByName(condition);
  }

}
