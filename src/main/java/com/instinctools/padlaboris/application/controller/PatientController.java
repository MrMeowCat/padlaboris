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

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Method for fetch all Patient from database.
     *
     * @return List of PatientDto patientDto.
     */
    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public ResponseEntity fetchAllPatients() {

        final List<PatientDto> response = new ArrayList<>();
        patientService.listPatients()
                .forEach(patient -> response.add(dozerBeanMapper.map(patient, PatientDto.class)));

        return ResponseEntity.ok().body(response);
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

    /**
     * Method for fetch patient by gender.
     *
     * @param gender Patient gender.
     * @return List of PatientDto patientDto.
     */
    @RequestMapping(value = "/patients/gender/{gender}", method = RequestMethod.GET)
    public ResponseEntity fetchByGender(@PathVariable final String gender) {

        final List<PatientDto> response = new ArrayList<>();
        patientService.findByGender(gender)
                .forEach(patient -> response.add(dozerBeanMapper.map(patient, PatientDto.class)));

        return ResponseEntity.ok().body(response);
    }

    /**
     * Method for fetch patient by last name.
     *
     * @param lastName Patient lastName.
     * @return List of PatientDto patientDto.
     */
    @RequestMapping(value = "/patients/lastName/{lastName}", method = RequestMethod.GET)
    public ResponseEntity fetchByLastName(@PathVariable final String lastName) {

        final List<PatientDto> response = new ArrayList<>();
        patientService.findByLastName(lastName)
                .forEach(patient -> response.add(dozerBeanMapper.map(patient, PatientDto.class)));

        return ResponseEntity.ok().body(response);
    }
}
