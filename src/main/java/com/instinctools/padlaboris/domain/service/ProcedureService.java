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

    /**
     * Finds a procedure by id.
     * @param procedureId id of a procedure
     * @return a procedure
     */
    Procedure findById(Integer procedureId);

    /**
     * Saves a procedure.
     * @param procedure a procedure to save
     * @return a saved procedure
     */
    Procedure save(Procedure procedure);

    /**
     * Checks if a procedure exists in database.
     * @param procedureId id of a procedure
     * @return true if exists, false otherwise
     */
    boolean exists(Integer procedureId);
}
