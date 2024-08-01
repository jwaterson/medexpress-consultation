package com.medexpressconsultation.repository;

import com.medexpressconsultation.model.Condition;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {
  Optional<Condition> findByName(String name);
}
