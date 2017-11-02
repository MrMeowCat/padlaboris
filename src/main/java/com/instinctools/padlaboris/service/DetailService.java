package com.instinctools.padlaboris.service;

import com.instinctools.padlaboris.model.Detail;

import java.util.List;

/**
 * Interface for Detail work with database.
 */
public interface DetailService {

    /**
     * Method for add detail to database.
     *
     * @param detail Detail detail.
     * @return object of the added Detail class
     */
    Detail create(Detail detail);

    /**
     * Method for display detail from database by id.
     *
     * @param id Detail id.
     * @return object of detail class with this id.
     */
    Detail fetch(Integer id);

    /**
     * Method for update detail to database.
     *
     * @param detail Detail detail.
     * @return updated object of Detail class.
     */
    Detail update(Detail detail);

    /**
     * Method for remove detail from database.
     *
     * @param id Detail id.
     */
    void delete(Integer id);

    /**
     * Method for search details in database by bmi.
     *
     * @param bMI Detail bMI.
     * @return List of Detail objects with this bmi.
     */
    List<Detail> findByBMI(double bMI);

    /**
     * Method for search details in database by bloodType.
     *
     * @param bloodType Detail bloodType.
     * @return List of Detail objects with this bloodType.
     */
    List<Detail> findByBloodType(Integer bloodType);

    /**
     * Method for display all details from data base.
     *
     * @return List of Detail objects.
     */
    List<Detail> listDetails();
}
