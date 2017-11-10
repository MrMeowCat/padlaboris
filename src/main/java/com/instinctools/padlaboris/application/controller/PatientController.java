package com.instinctools.padlaboris.application.controller;

import com.instinctools.padlaboris.application.dto.PatientDto;
import com.instinctools.padlaboris.domain.model.Patient;
import com.instinctools.padlaboris.domain.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for Patient.
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PatientController {

    private final PatientService patientService;

    /**
     * Mapper for convert PatientDto to Patient and back.
     */
    private final DozerBeanMapper dozerBeanMapper;

    /**
     * Method for updating Patient.
     *
     * @param patientDto PatientDto patientDto.
     * @return created PatientDto patientDto.
     */
    @RequestMapping(value = "/patients", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody final PatientDto patientDto) {

        final Patient patientToUpdate = dozerBeanMapper.map(patientDto, Patient.class);

        final Patient patientToResponse = patientService.update(patientToUpdate);

        final PatientDto response = dozerBeanMapper.map(patientToResponse, PatientDto.class);

        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public ResponseEntity fetchAllPatients() {

        return ResponseEntity.ok().body(patientService.listPatients());
    }

    /**
     * Method for displaying Patient.
     *
     * @param id Patient id.
     * @return PatentDto patientDto which want displayed.
     */
    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
    public ResponseEntity fetchPatient(@PathVariable final Integer id) {

        final Patient patientToResponse = patientService.fetch(id);

        final PatientDto response = dozerBeanMapper.map(patientToResponse, PatientDto.class);

        return ResponseEntity.ok().body(response);
    }

    /**
     * Method for creating Patient.
     *
     * @param patientDto PatientDto.
     * @return created PatientDto patientDto.
     */
    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    public ResponseEntity createPatient(@RequestBody final PatientDto patientDto) {

        final Patient patientToCreate = dozerBeanMapper.map(patientDto, Patient.class);

        final Patient patientToResponse = patientService.create(patientToCreate);

        final PatientDto response = dozerBeanMapper.map(patientToResponse, PatientDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Method for deleting Patient from database.
     *
     * @param id Patient id.
     * @return deleted PatientDto patientDto.
     */
    @RequestMapping(value = "/patients/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePatient(@PathVariable final Integer id) {

        final Patient patientToResponse = patientService.fetch(id);

        final PatientDto response = dozerBeanMapper.map(patientToResponse, PatientDto.class);

        patientService.delete(id);

        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/patients/gender/{gender}", method = RequestMethod.GET)
    public ResponseEntity fetchByGender(@PathVariable final String gender) {

        return ResponseEntity.ok().body(patientService.findByGender(gender));
    }

    @RequestMapping(value = "/patients/lastName/{lastName}", method = RequestMethod.GET)
    public ResponseEntity fetchByLastName(@PathVariable final String lastName) {

        return ResponseEntity.ok().body(patientService.findByLastName(lastName));
    }
}
