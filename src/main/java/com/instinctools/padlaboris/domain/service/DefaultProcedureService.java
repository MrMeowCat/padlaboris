package com.instinctools.padlaboris.domain.service;

import com.instinctools.padlaboris.domain.exception.ResourceNotFoundException;
import com.instinctools.padlaboris.domain.model.Procedure;
import com.instinctools.padlaboris.domain.repository.ProcedureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link DiseaseService}.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultProcedureService implements ProcedureService {

    private final ProcedureRepository procedureRepository;

    @Override
    public List<Procedure> findByPatientId(final Integer patientId) {
        return procedureRepository.findByPatientId(patientId);
    }

    @Override
    public Procedure findById(final Integer procedureId) {
        return Optional
                .ofNullable(procedureRepository.findOne(procedureId))
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Procedure save(final Procedure procedure) {
        return procedureRepository.save(procedure);
    }

    @Override
    public boolean exists(final Integer procedureId) {
        return procedureRepository.exists(procedureId);
    }
}
