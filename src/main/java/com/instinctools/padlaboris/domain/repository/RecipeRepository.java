package com.instinctools.padlaboris.domain.repository;

import com.instinctools.padlaboris.domain.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Recipe Repository.
 */
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    @Query(value = "SELECT * FROM recipe WHERE medicine_name=?1", nativeQuery = true)
    List<Recipe> findByMedicineName(String medicineName);
}
