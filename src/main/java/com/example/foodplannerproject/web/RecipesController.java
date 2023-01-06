package com.example.foodplannerproject.web;


import com.example.foodplannerproject.domain.Recipe;
import com.example.foodplannerproject.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String showAllRecipesApp(Model model) {
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipeList", recipes);

        return "recipes";
    }

    @GetMapping("/app/recipe/add")
    public String showRecipeAdd() {
        return "appRecipeAdd";
    }

    @PostMapping("/app/recipe/add")
    public String saveNewRecipe(@RequestParam String name,
                                @RequestParam String description,
                                @RequestParam String preparationTime,
                                @RequestParam String preparation,
                                @RequestParam String ingredients) {
        if (name.isEmpty() || description.isEmpty() || preparationTime.isEmpty() || preparation.isEmpty() || ingredients.isEmpty()) {
            return "appRecipeAdd";
        } else {
            Recipe newRecipe = new Recipe();
            newRecipe.setName(name);
            newRecipe.setDescription(description);
            newRecipe.setPreparationTime(Integer.parseInt(preparationTime));
            newRecipe.setIngredients(ingredients);

            recipeService.saveRecipe(newRecipe);
            return "redirect:/app/dashboard";
        }
    }

    @GetMapping("/recipes/details")
    public String showRecipeDetails(@RequestParam String id,
                                    Model model) {
        Recipe recipeToShow = recipeService.findRecipeById(Long.parseLong(id));
        model.addAttribute("recipe", recipeToShow);

        return "appRecipeDetails";
    }

}
