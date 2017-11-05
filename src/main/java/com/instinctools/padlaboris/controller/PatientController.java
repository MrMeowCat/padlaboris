package com.instinctools.padlaboris.controller;

import com.instinctools.padlaboris.dto.PatientDto;
import com.instinctools.padlaboris.model.Patient;
import com.instinctools.padlaboris.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Patient controller.
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PatientController {

    private final PatientService patientService;

    /**
     * Mapper for convert Patient to PatientDto and back.
     */
    private DozerBeanMapper dozerBeanMapper;

    /**
     * Method for update Patient from data base.
     *
     * @param patientDto PatientDto patientDto.
     * @param id Patient id.
     * @return updated Patient class object which transformed to PatientDto.
     */
    @RequestMapping(value = "/patients/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody final PatientDto patientDto, @PathVariable final Integer id) {

        this.dozerBeanMapper = new DozerBeanMapper();

       final Patient patient = dozerBeanMapper.map(patientDto, Patient.class);

        patientService.updateById(id, patient);

        return ResponseEntity.ok().body(dozerBeanMapper.map(patientService.fetch(id), PatientDto.class));
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public ResponseEntity fetchAllPatients() {

        return ResponseEntity.ok().body(patientService.listPatients());
    }

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
    public ResponseEntity fetchPatient(@PathVariable final Integer id) {

        this.dozerBeanMapper = new DozerBeanMapper();

        return ResponseEntity.ok().body(dozerBeanMapper.map(patientService.fetch(id), PatientDto.class));
    }

    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    public ResponseEntity createPatient(@RequestBody final PatientDto patientDto) {

        this.dozerBeanMapper = new DozerBeanMapper();

        final PatientDto response = dozerBeanMapper.map(patientService.create(dozerBeanMapper.map(patientDto, Patient.class)),
                PatientDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePatient(@PathVariable final Integer id) {

        this.dozerBeanMapper = new DozerBeanMapper();

        final PatientDto response = dozerBeanMapper.map(patientService.fetch(id), PatientDto.class);

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
