package com.instinctools.padlaboris.repository;

import com.instinctools.padlaboris.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Interface for working with the database.
 */
public interface DetailRepository extends JpaRepository<Detail, Integer> {
    /**
     * Method find details by bmi.
     *
     * @param bMI Detail bMI.
     * @return List of Detail class objects with this bmi.
     */
    @Query(value = "SELECT * FROM details WHERE bmi=?1", nativeQuery = true)
    List<Detail> findByBMI(double bMI);

    /**
     * Method find details by blood type.
     *
     * @param bloodType Detail bloodType.
     * @return List of Detail class objects with this blood type.
     */
    @Query(value = "SELECT * FROM details WHERE blood_type=?1", nativeQuery = true)
    List<Detail> findByBloodType(Integer bloodType);

}
