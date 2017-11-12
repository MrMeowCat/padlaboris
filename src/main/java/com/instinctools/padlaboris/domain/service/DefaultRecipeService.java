package com.instinctools.padlaboris.domain.service;


import com.instinctools.padlaboris.domain.model.Recipe;
import com.instinctools.padlaboris.domain.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultRecipeService implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public Recipe fetch(final Integer id) {
        return recipeRepository.findOne(id);
    }

    @Override
    public Recipe create(final Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(final Integer id) {
        recipeRepository.delete(id);
    }

    @Override
    public List<Recipe> findByMedicineName(final String medicineName) {
        return recipeRepository.findByMedicineName(medicineName);
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }
}
