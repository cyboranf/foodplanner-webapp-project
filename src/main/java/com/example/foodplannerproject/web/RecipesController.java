package com.example.foodplannerproject.web;


import com.example.foodplannerproject.domain.Recipe;
import com.example.foodplannerproject.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RecipesController {
    private final RecipeService recipeService;

    public RecipesController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping("/recipes")
    public String showAllRecipes(Model model) {
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipeList", recipes);

        return "recipes";
    }
    @GetMapping("/app/recipe/list")
    public String showAllRecipesApp(Model model){
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipeList", recipes);

        return "recipes";
    }

}
