package com.instinctools.padlaboris.controller;

import com.instinctools.padlaboris.dto.PatientDto;
import com.instinctools.padlaboris.model.Patient;
import com.instinctools.padlaboris.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PatientController {

    private final PatientService patientService;

    private final DozerBeanMapper dozerBeanMapper;

    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    public ResponseEntity createPatient(@RequestBody PatientDto patientDto) {
        final Patient patient = dozerBeanMapper.map(patientDto, Patient.class);

        return ResponseEntity.ok().body(patientService.create(patient));
    }

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.PUT)
    public ResponseEntity updatePatient(@RequestBody PatientDto patientDto, @PathVariable("id") Integer id) {


        final Patient patient = dozerBeanMapper.map(patientDto, Patient.class);
        patient.setId(patientService.read(id).getId());

        return ResponseEntity.ok().body(patientService.update(patient));

    }

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
    public ResponseEntity fetchPatient(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(patientService.read(id));
    }

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePatient(@PathVariable("id") Integer id) {
        final Patient patient = patientService.read(id);
        patientService.delete(id);
        return ResponseEntity.ok().body(patient);
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public ResponseEntity fetchAll() {
        return ResponseEntity.ok().body(patientService.listPatients());
    }
}
