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

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PatientController {

    private final PatientService patientService;

    private DozerBeanMapper dozerBeanMapper;

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody PatientDto patientDto, @PathVariable Integer id) {
        this.dozerBeanMapper = new DozerBeanMapper();
        Patient patient = dozerBeanMapper.map(patientDto, Patient.class);

        return ResponseEntity.ok().body(patientService.updateById(id, patient.getFirstName()));
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public ResponseEntity fetchAllPatients() {
        return ResponseEntity.ok().body(patientService.listPatients());
    }

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
    public ResponseEntity fetchPatient(@PathVariable Integer id) {
        return ResponseEntity.ok().body(patientService.fetch(id));
    }

    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    public ResponseEntity createPatient(@RequestBody PatientDto patientDto)

    {
        this.dozerBeanMapper = new DozerBeanMapper();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(patientService.create(dozerBeanMapper.map(patientDto, Patient.class)));
    }

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePatient(@PathVariable Integer id) {
        Patient patient = patientService.fetch(id);

        patientService.delete(id);

        return ResponseEntity.ok().body(patient);
    }

    @RequestMapping(value = "/patients/gender/{gender}", method = RequestMethod.GET)
    public ResponseEntity fetchByGender(@PathVariable String gender) {
        return ResponseEntity.ok().body(patientService.findByGender(gender));
    }

    @RequestMapping(value = "/patients/lastName/{lastName}", method = RequestMethod.GET)
    public ResponseEntity fetchByLastName(@PathVariable String lastName) {

        return ResponseEntity.ok().body(patientService.findByLastName(lastName));
    }
}
