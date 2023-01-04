package com.example.foodplannerproject.service;

import com.example.foodplannerproject.domain.Recipe;
import com.example.foodplannerproject.repository.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return recipe;
    }

    public Integer countOfRecipes() {
        return recipeRepository.quantityOfAllRecipes();
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }
}
