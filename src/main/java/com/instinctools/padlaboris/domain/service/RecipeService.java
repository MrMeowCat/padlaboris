package com.instinctools.padlaboris.domain.service;

import com.instinctools.padlaboris.domain.model.Recipe;

import java.util.List;

/**
 * Recipe service interface.
 */
public interface RecipeService {

    /**
     * Method fetches Recipe from database by id.
     *
     * @param id Recipe id
     * @return Recipe
     */
    Recipe fetch(Integer id);

    /**
     * Method adds new Recipe to database.
     *
     * @param recipe Recipe
     * @return Recipe
     */
    Recipe create(Recipe recipe);

    /**
     * Method deletes Recipe from database by id.
     *
     * @param id Recipe id
     */
    void delete(Integer id);

    /**
     * Method searches for Recipe by start date.
     *
     * @param medicineName start date
     * @return list of Recipes
     */
    List<Recipe> findByMedicineName(String medicineName);

    /**
     * Method searches for all Recipes.
     *
     * @return list of Recipes
     */
    List<Recipe> findAll();
}
