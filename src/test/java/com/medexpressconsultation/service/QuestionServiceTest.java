package com.medexpressconsultation.service;

import com.medexpressconsultation.dto.QuestionDTO;
import com.medexpressconsultation.mapper.QuestionDTOMapper;
import com.medexpressconsultation.model.question.Question;
import com.medexpressconsultation.model.question.QuestionType;
import com.medexpressconsultation.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class QuestionServiceTest {

  @Mock
  private QuestionRepository questionRepository;

  @Mock
  private QuestionDTOMapper questionMapper;

  @InjectMocks
  private QuestionService questionService;
  private Long conditionId;
  private Question question1;
  private Question question2;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    conditionId = 1L;

    question1 = new Question();
    question1.setConditionId(conditionId);
    question1.setQuestionType(QuestionType.CURRENT_HEALTH);
    question1.setText("you smoke?");
    question1.setResponseRequiredForMedication(true);
    question1.setOrdinal(0);

    question2 = new Question();
    question2.setConditionId(conditionId);
    question2.setQuestionType(QuestionType.CURRENT_HEALTH);
    question2.setText("you drink?");
    question2.setResponseRequiredForMedication(false);
    question2.setOrdinal(1);
  }

  @Test
  void getQuestionsByConditionId_twoQuestions_bothReturnedInCorrectOrder() {
    List<Question> questions = Arrays.asList(question1, question2);

    QuestionDTO questionDTO1 = new QuestionDTO(question1);
    QuestionDTO questionDTO2 = new QuestionDTO(question2);

    when(questionRepository.findByConditionId(conditionId)).thenReturn(Optional.of(questions));
    when(questionMapper.toDTO(question1)).thenReturn(questionDTO1);
    when(questionMapper.toDTO(question2)).thenReturn(questionDTO2);

    List<QuestionDTO> result = questionService.getQuestionsByConditionId(conditionId);

    verify(questionRepository, times(1)).findByConditionId(conditionId);
    verify(questionMapper, times(1)).toDTO(question1);
    verify(questionMapper, times(1)).toDTO(question2);

    assertEquals(2, result.size());
    assertEquals(questionDTO1, result.get(0));
    assertEquals(questionDTO2, result.get(1));
  }

  @Test
  void getQuestionsByConditionId_noQuestionsForGivenConditionId_throwsExceptionWhenNotFound() {
    when(questionRepository.findByConditionId(conditionId)).thenReturn(Optional.empty());

    assertThrows(RuntimeException.class, () -> questionService.getQuestionsByConditionId(conditionId));

    verify(questionRepository, times(1)).findByConditionId(conditionId);
    verifyNoMoreInteractions(questionMapper);
  }
}
