package com.instinctools.padlaboris.domain.service;

import com.instinctools.padlaboris.domain.model.Procedure;

import java.util.List;

/**
 * Service for {@link Procedure}.
 */
public interface ProcedureService {

    /**
     * Finds procedures assigned for a specific patient.
     * @param patientId id of a patient
     * @return a list of procedures
     */
    List<Procedure> findByPatientId(Integer patientId);

    Procedure findById(Integer procedureId);

    Procedure save(Procedure procedure);

    boolean exists(Integer procedureId);
}
