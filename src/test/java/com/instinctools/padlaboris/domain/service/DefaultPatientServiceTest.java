package com.instinctools.padlaboris.domain.service;

import com.instinctools.padlaboris.domain.model.Patient;
import com.instinctools.padlaboris.domain.repository.PatientRepository;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultPatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    private Integer id;

    private Patient patient;

    @Before
    public void setUp() {

        patient = new Patient();

        patient.setLastName("lastName");
        patient.setGender("male");

        id = patientRepository.save(patient).getId();
    }

    @Test
    public void create() {

        final String content = "newPatientLastName";

        patient.setLastName(content);

        final Patient saved = patientService.create(patient);

        assertThat(saved.getLastName(), Is.is(content));
    }

    @Test
    public void update() {

        final String content = "updatePatientLastName";

        final Patient updatePatient = patientRepository.findOne(id);

        updatePatient.setLastName(content);

        updatePatient.setId(id);

        patientService.update(updatePatient);

        assertThat(patientRepository.findOne(id).getLastName(), Is.is(content));
    }

    @Test
    public void fetch() {

        final String content = "lastName";

        assertThat(patientService.fetch(id).getLastName(), Is.is(content));
    }

    @Test
    public void findByLastName() {

        final String content = "lastName";

        final List<Patient> patients = patientService.findByLastName(content);

        assertThat(patients.get(0).getLastName(), Is.is(content));
    }

    @Test
    public void findByGender() {

        final String content = "male";

        final List<Patient> patients = patientService.findByGender(content);

        assertThat(patients.get(0).getGender(), Is.is(content));
    }

    @Test
    public void delete() {

        patientService.delete(id);

        assertThat(patientRepository.exists(id), Is.is(false));
    }
}
