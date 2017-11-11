package com.instinctools.padlaboris.application.repository;

import com.instinctools.padlaboris.domain.model.Patient;
import com.instinctools.padlaboris.domain.model.Procedure;
import com.instinctools.padlaboris.domain.repository.PatientRepository;
import com.instinctools.padlaboris.domain.repository.ProcedureRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProcedureRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ProcedureRepository procedureRepository;

    @Before
    public void init() {
        final Patient patient = new Patient();
        patient.setLastName("lastName");
        patient.setGender("male");

        final Procedure procedure = new Procedure();
        procedure.setProcedureName("Yoga");
        procedure.setPatient(patient);
        procedure.setDate(new Date());


//        procedureRepository.save(procedure); saves both

        patient.setProcedures(Arrays.asList(procedure));
        //patient.getProcedures().add(procedure);
        patientRepository.save(patient); //saves both
    }

    @Test
    public void testGet() {
        final List<Procedure> procedures = procedureRepository.findAll();
        Assert.assertEquals(1, procedures.size());

        final List<Patient> patients = patientRepository.findAll();
        Assert.assertEquals(1, patients.size());
    }
}
