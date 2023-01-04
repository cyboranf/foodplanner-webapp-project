package com.example.foodplannerproject.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipesController {
    @GetMapping("/recipes")
    public String showAllRecipes() {
        return "recipes";
    }
}
