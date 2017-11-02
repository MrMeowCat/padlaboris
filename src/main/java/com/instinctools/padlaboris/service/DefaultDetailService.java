package com.instinctools.padlaboris.service;

import com.instinctools.padlaboris.model.Detail;
import com.instinctools.padlaboris.repository.DetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * class that implements the Detail's work and databases.
 */
@Service
@Slf4j
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultDetailService implements DetailService {

    private final DetailRepository detailRepository;

    @Override
    public Detail create(Detail detail) {

        log.info("Detail added to database.");

        return detailRepository.save(detail);
    }

    @Override
    public Detail fetch(Integer id) {

        log.info("Detail displayed.");

        return detailRepository.findOne(id);
    }

    @Override
    public Detail update(Detail detail) {

        log.info("Detail updated.");

        return detailRepository.save(detail);
    }

    @Override
    public void delete(Integer id) {

        log.info("Detail deleted from database.");

        detailRepository.delete(id);
    }

    @Override
    public List<Detail> findByBMI(double bMI) {

        log.info("Detail were find by bmi and displayed.");

        return detailRepository.findByBMI(bMI);
    }


    @Override
    public List<Detail> findByBloodType(Integer bloodType) {

        log.info("Detail were find by blood type and displayed.");

        return detailRepository.findByBloodType(bloodType);
    }

    @Override
    public List<Detail> listDetails() {

        log.info("All patients were displayed");

        return detailRepository.findAll();
    }
}
