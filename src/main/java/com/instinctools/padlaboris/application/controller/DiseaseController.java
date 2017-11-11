package com.instinctools.padlaboris.application.controller;

import com.instinctools.padlaboris.application.dto.DiseaseDto;
import com.instinctools.padlaboris.domain.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for {@link com.instinctools.padlaboris.domain.model.Disease}.
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DiseaseController {

    private final DiseaseService diseaseService;
    private final DozerBeanMapper dozerBeanMapper;

    @GetMapping("patients/{id}/diseases")
    public ResponseEntity getPatientDiseases(@PathVariable("id") final Integer patientId) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("diseases/{id}")
    public ResponseEntity getDisease(@PathVariable("id") final Integer diseaseId) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("patients/{id}/diseases")
    public ResponseEntity addDisease(@RequestBody final DiseaseDto diseaseDto,
                                     @PathVariable("id") final Integer patientId) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("patients/{id}/diseases")
    public ResponseEntity updateDisease(@RequestBody final DiseaseDto diseaseDto,
                                        @PathVariable("id") final Integer patientId) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("patients/{patientId}/diseases/{diseaseId}")
    public ResponseEntity deleteDisease(@PathVariable("patientId") final Integer patientId,
                                        @PathVariable("diseaseId") final Integer diseaseId) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
