package com.instinctools.padlaboris.domain.service;

import com.instinctools.padlaboris.domain.model.Detail;

import java.util.List;

/**
 * Interface for Detail work with database.
 */
public interface DetailService {

    /**
     * Persist {@link Detail} entity.
     *
     * @param id     a entity id
     * @param detail an entity
     * @return persisted entity.
     */
    Detail create(Integer id, Detail detail);

    /**
     * Method for display detail from database by id.
     *
     * @param id Detail id.
     * @return object of detail class with this id.
     */
    Detail fetch(Integer id);

    /**
     * Method for remove detail from database.
     *
     * @param id Detail id.
     */
    void delete(Integer id);

    /**
     * Method for search details in database by findByRhesusFactor.
     *
     * @param findByRhesusFactor Detail findByRhesusFactor.
     * @return List of Detail objects with this findByRhesusFactor.
     */
    List<Detail> findByRhesusFactor(String findByRhesusFactor);

    /**
     * Method for search details in database by bloodType.
     *
     * @param bloodType Detail bloodType.
     * @return List of Detail objects with this bloodType.
     */
    List<Detail> findByBloodType(Integer bloodType);

    /**
     * Method for display all details from database.
     *
     * @return List of Detail objects.
     */
    List<Detail> listDetails();

    /**
     * Method for update detail from database.
     *
     * @param detail Detail detail.
     * @return updated Detail detail.
     */
    Detail update(Detail detail);
}
