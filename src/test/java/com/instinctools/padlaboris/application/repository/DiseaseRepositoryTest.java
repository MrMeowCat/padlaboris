package com.instinctools.padlaboris.application.repository;

import com.instinctools.padlaboris.domain.model.Disease;
import com.instinctools.padlaboris.domain.repository.DiseaseRepository;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DiseaseRepositoryTest {

    @Autowired
    private DiseaseRepository diseaseRepository;

    private Integer id;

    @Before
    public void setUp() {
        final Disease disease = new Disease();

        disease.setDiseaseName("cancer");
        disease.setDiseaseCode("123");
        disease.setDiseaseDescription("you're dead");
        disease.setDiseaseCode("hardcore");

        id = diseaseRepository.save(disease).getId();
    }

    @Test
    public void testFind() {
        final List list = diseaseRepository.findAll();
        assertEquals(1, list.size());
    }

    @Test
    public void testFindByDiseaseName() {
        final List list = diseaseRepository.findByDiseaseName("cancer");
        assertEquals(1, list.size());
    }

    @Test
    public void testFindByDiseaseClass() {

        final List list = diseaseRepository.findByDiseaseClass("hard");
        assertEquals(0, list.size());
    }

    @Test
    public void testUpdate() {

        final Disease disease = diseaseRepository.findOne(id);

        final String content = "ASJDNAIEUFOEF";

        disease.setDiseaseName(content);
        diseaseRepository.save(disease);

        assertThat(diseaseRepository.findOne(id).getDiseaseName(), Is.is(content));
    }
}
