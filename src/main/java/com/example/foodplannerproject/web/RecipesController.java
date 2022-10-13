package com.example.foodplannerproject.web;

import com.example.foodplannerproject.domain.Recipe;
import com.example.foodplannerproject.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class RecipesController {
    private final RecipeService recipeService;

    public RecipesController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public ModelAndView show(HttpServletResponse response,
                             HttpServletRequest request){
        List<Recipe> recipeList=recipeService.findAll();
        request.setAttribute("recipeList",recipeList);

        return new ModelAndView("recipes");
    }
}
