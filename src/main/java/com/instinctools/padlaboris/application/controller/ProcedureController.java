package com.instinctools.padlaboris.application.controller;

import com.instinctools.padlaboris.application.dto.ProcedureDto;
import com.instinctools.padlaboris.domain.model.Patient;
import com.instinctools.padlaboris.domain.model.Procedure;
import com.instinctools.padlaboris.domain.service.PatientService;
import com.instinctools.padlaboris.domain.service.ProcedureService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for {@link com.instinctools.padlaboris.domain.model.Procedure}.
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProcedureController {

    private final PatientService patientService;

    private final ProcedureService procedureService;

    private final DozerBeanMapper dozerBeanMapper;

    /**
     * Fetches procedures of a patient.
     * @param patientId id of a patient
     * @return ResponseEntity with a list of procedures
     */
    @GetMapping("patients/{id}/procedures")
    public ResponseEntity getPatientProcedures(@PathVariable("id") final Integer patientId) {
        final List<Procedure> procedures = procedureService.findByPatientId(patientId);
        final List<ProcedureDto> procedureDtos = new ArrayList<>();

        procedures.forEach(procedure -> procedureDtos
                .add(dozerBeanMapper.map(procedure, ProcedureDto.class)));

        return ResponseEntity.ok(procedureDtos);
    }

    /**
     * Fetches a procedure.
     * @param procedureId id of a procedure
     * @return a procedure
     */
    @GetMapping("procedures/{id}")
    public ResponseEntity getProcedure(@PathVariable("id") final Integer procedureId) {
        final Procedure procedure = procedureService.findById(procedureId);
        final ProcedureDto procedureDto = dozerBeanMapper.map(procedure, ProcedureDto.class);

        return ResponseEntity.ok(procedureDto);
    }

    /**
     * Saves a procedure for a patient.
     * @param patientId id of a patient
     * @param procedureDto procedure dto
     * @return ResponseEntity with a saved procedure
     */
    @PostMapping("patients/{id}/procedures")
    public ResponseEntity addProcedure(@PathVariable("id") final Integer patientId,
                                       @RequestBody final ProcedureDto procedureDto) {
        final Patient patient = patientService.fetch(patientId);
        final Procedure procedure = dozerBeanMapper.map(procedureDto, Procedure.class);

        procedure.setPatient(patient);

        final Procedure saved = procedureService.save(procedure);
        final ProcedureDto converted = dozerBeanMapper.map(saved, ProcedureDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(converted);
    }
}
