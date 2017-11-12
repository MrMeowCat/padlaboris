package com.instinctools.padlaboris.domain.service;

import com.instinctools.padlaboris.domain.model.MedicalLeave;

import java.util.Date;
import java.util.List;

/**
 * Medical leave service interface.
 */
public interface MedicalLeaveService {

    /**
     * Method fetches Medical leave from database by id.
     *
     * @param id Medical leave id
     * @return Medical leave
     */
    MedicalLeave fetch(Integer id);

    /**
     * Method adds new Medical leave to database.
     *
     * @param medicalLeave Medical leave
     * @return Medical leave
     */
    MedicalLeave create(MedicalLeave medicalLeave);

    /**
     * Method deletes Medical leave from database by id.
     *
     * @param id Medical leave id
     */
    void delete(Integer id);

    /**
     * Method searches for Medical leave by start date
     *
     * @param startDate start date
     * @return list of Medical leaves
     */
    List<MedicalLeave> findByStartDate(Date startDate);

    /**
     * Method searches for all Medical leaves.
     *
     * @return list of Medical leaves
     */
    List<MedicalLeave> findAll();
}
