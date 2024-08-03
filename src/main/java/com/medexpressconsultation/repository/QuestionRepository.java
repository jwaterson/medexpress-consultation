package com.medexpressconsultation.repository;

import com.medexpressconsultation.model.question.Question;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

  Optional<List<Question>> findByConditionId(Long conditionId);

}
