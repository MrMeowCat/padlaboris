package com.instinctools.padlaboris.application.controller;

import com.instinctools.padlaboris.application.dto.RecipeDto;
import com.instinctools.padlaboris.domain.model.Disease;
import com.instinctools.padlaboris.domain.model.Recipe;
import com.instinctools.padlaboris.domain.service.DiseaseService;
import com.instinctools.padlaboris.domain.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for {@link Recipe}.
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RecipeController {

    private final DiseaseService diseaseService;

    private final RecipeService recipeService;

    private final DozerBeanMapper dozerBeanMapper;

    /**
     * Finds recipes for a disease.
     * @param diseaseId id of a disease
     * @return a list of recipes
     */
    @GetMapping("diseases/{diseaseId}/recipes")
    public ResponseEntity getRecipes(@PathVariable("diseaseId") final Integer diseaseId) {
        final List<Recipe> recipes = recipeService.findByDiseaseId(diseaseId);
        final List<RecipeDto> recipeDtos = new ArrayList<>();

        recipes.forEach(recipe -> recipeDtos.add(dozerBeanMapper.map(recipe, RecipeDto.class)));

        return ResponseEntity.ok(recipeDtos);
    }

    /**
     * Finds a recipe.
     * @param recipeId id of a recipe
     * @return a recipe
     */
    @GetMapping("recipes/{recipeId}")
    public ResponseEntity getRecipe(@PathVariable("recipeId") final Integer recipeId) {
        final Recipe recipe = recipeService.fetch(recipeId);
        final RecipeDto recipeDto = dozerBeanMapper.map(recipe, RecipeDto.class);

        return ResponseEntity.ok(recipeDto);
    }

    /**
     * Creates a new recipe for a disease.
     * @param diseaseId id of a disease
     * @param recipeDto recipe body
     * @return saved recipe
     */
    @PostMapping("diseases/{diseaseId}/recipes")
    public ResponseEntity addRecipe(@PathVariable("diseaseId") final Integer diseaseId,
                                    @RequestBody final RecipeDto recipeDto) {
        final Disease disease = diseaseService.findById(diseaseId);
        final Recipe recipe = dozerBeanMapper.map(recipeDto, Recipe.class);

        recipe.setDisease(disease);

        final Recipe saved = recipeService.create(recipe);
        final RecipeDto converted = dozerBeanMapper.map(saved, RecipeDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(converted);
    }

    /**
     * Updates a new recipe for a disease.
     * @param diseaseId id of a disease
     * @param recipeDto recipe body
     * @return saved recipe
     */
    @PutMapping("diseases/{diseaseId}/recipes")
    public ResponseEntity updateRecipe(@PathVariable("diseaseId") final Integer diseaseId,
                                       @RequestBody final RecipeDto recipeDto) {
        final Disease disease = diseaseService.findById(diseaseId);
        final Recipe recipe = dozerBeanMapper.map(recipeDto, Recipe.class);

        recipe.setDisease(disease);

        final Recipe saved = recipeService.create(recipe);
        final RecipeDto converted = dozerBeanMapper.map(saved, RecipeDto.class);

        return ResponseEntity.ok(converted);
    }

    /**
     * Deletes a recipe from disease.
     * @param diseaseId id of a disease
     * @param recipeId id of a recipe
     * @return 204
     */
    @DeleteMapping("diseases/{diseaseId}/recipes/{recipeId}")
    public ResponseEntity deleteRecipe(@PathVariable("diseaseId") final Integer diseaseId,
                                       @PathVariable("recipeId") final Integer recipeId) {
        final Disease disease = diseaseService.findById(diseaseId);
        final Recipe recipe = recipeService.fetch(recipeId);

        disease.getRecipes().remove(recipe);

        diseaseService.save(disease);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
