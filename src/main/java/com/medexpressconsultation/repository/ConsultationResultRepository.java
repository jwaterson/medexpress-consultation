package com.medexpressconsultation.repository;

import com.medexpressconsultation.model.ConsultationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationResultRepository extends JpaRepository<ConsultationResult, Long> {
}