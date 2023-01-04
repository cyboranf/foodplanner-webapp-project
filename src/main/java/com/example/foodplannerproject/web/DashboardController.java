package com.example.foodplannerproject.web;

import com.example.foodplannerproject.domain.Plan;

import com.example.foodplannerproject.service.PlanService;
import com.example.foodplannerproject.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {
    private final PlanService planService;
    private final RecipeService recipeService;

    public DashboardController(PlanService planService, RecipeService recipeService) {
        this.planService = planService;
        this.recipeService = recipeService;
    }

    @GetMapping("/app/dashboard")
    public String viewOfDashboardJsp(Model model) {
        List<Plan> plans = planService.findAll();
        Plan plan = plans.get(plans.size() - 1);

        model.addAttribute("numberOfPlans", planService.quantityOfPlans());
        model.addAttribute("numberOfRecipe", recipeService.countOfRecipes());
        model.addAttribute("lastPlan", plan);

        return "dashboard";
    }
}
