package com.instinctools.padlaboris.domain.repository;

import com.instinctools.padlaboris.domain.model.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for {@link Procedure}.
 */
public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {

    /**
     * Finds procedures assigned for a specific patient.
     * @param patientId id of a patient
     * @return a list of procedures
     */
    List<Procedure> findByPatientId(Integer patientId);

}
