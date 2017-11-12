package com.instinctools.padlaboris.domain.service;

import com.instinctools.padlaboris.domain.model.MedicalLeave;
import com.instinctools.padlaboris.domain.repository.MedicalLeaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultMedicalLeaveService implements MedicalLeaveService {

    private final MedicalLeaveRepository medicalLeaveRepository;

    @Override
    public MedicalLeave fetch(final Integer id) {
        return medicalLeaveRepository.findOne(id);
    }

    @Override
    public MedicalLeave create(final MedicalLeave medicalLeave) {
        return medicalLeaveRepository.save(medicalLeave);
    }

    @Override
    public void delete(final Integer id) {
        medicalLeaveRepository.delete(id);
    }

    @Override
    public List<MedicalLeave> findByStartDate(final Date startDate) {
        return medicalLeaveRepository.findByStartDate(startDate);
    }

    @Override
    public List<MedicalLeave> findAll() {
        return medicalLeaveRepository.findAll();
    }
}
