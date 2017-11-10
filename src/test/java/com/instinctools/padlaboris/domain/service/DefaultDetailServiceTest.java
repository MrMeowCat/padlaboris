package com.instinctools.padlaboris.domain.service;

import com.instinctools.padlaboris.domain.model.Detail;
import com.instinctools.padlaboris.domain.model.Patient;
import com.instinctools.padlaboris.domain.repository.DetailRepository;
import com.instinctools.padlaboris.domain.repository.PatientRepository;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultDetailServiceTest {

    @Autowired
    private DetailService detailService;

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private PatientRepository patientRepository;

    private Integer patientId;

    private Integer id;

    @Before
    public void setUp() {

        final Patient patient = new Patient();

        patientId = patientRepository.save(patient).getId();

        final Detail detail = new Detail();

        detail.setBloodType(1);
        detail.setBmi(1.25);
        detail.setRhesusFactor("+");

        id = detailRepository.save(detail).getId();
    }

    @Test
    public void create() {

        final Integer content = 2;

        final Detail createDetail = new Detail();

        createDetail.setBloodType(content);

        detailService.create(patientId, createDetail);

        assertThat(detailRepository.findByBloodType(content).get(0).getBloodType(), Is.is(content));
    }

    @Test
    public void fetch() {

        final double content = 1.25;

        assertThat(detailService.fetch(id).getBmi(), Is.is(content));
    }

    @Test
    public void update() {

        final Integer content = 3;

        final Detail updateDetail = detailRepository.findOne(id);

        updateDetail.setBloodType(content);

        updateDetail.setId(id);

        detailService.update(updateDetail);

        assertThat(detailRepository.findOne(id).getBloodType(), Is.is(content));
    }

    @Test
    public void findByRhesusFactor() {

        final String content = "+";

        assertThat(detailService.findByRhesusFactor(content).get(0).getRhesusFactor(), Is.is(content));
    }

    @Test
    public void findByBloodType() {

        final Integer content = 1;

        assertThat(detailService.findByBloodType(content).get(0).getBloodType(), Is.is(content));
    }

    @Test
    public void delete() {

        detailService.delete(id);

        assertThat(detailRepository.exists(id), Is.is(false));
    }
}
