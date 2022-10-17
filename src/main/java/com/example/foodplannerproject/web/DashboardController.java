package com.example.foodplannerproject.web;

import com.example.foodplannerproject.domain.Plan;
import com.example.foodplannerproject.domain.Recipe;
import com.example.foodplannerproject.service.PlanService;
import com.example.foodplannerproject.service.RecipeService;
import com.example.foodplannerproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class DashboardController {
    public final PlanService planService;
    public final RecipeService recipeService;
    public final UserService userService;

    public DashboardController(PlanService planService, RecipeService recipeService, UserService userService) {
        this.planService = planService;
        this.recipeService = recipeService;
        this.userService = userService;
    }

    public int recipes = 0;
    public int plans = 0;

    @GetMapping("/app/dashboard")
    public ModelAndView showDashboard(HttpServletRequest request) {
        List<Recipe> recipeList = recipeService.findAll();
        for (Recipe recipe : recipeList) {
            recipes++;
        }
        List<Plan> planList = planService.findAll();
        for (Plan plan : planList) {
            plans++;
        }
        Plan lastPlan=planList.get(plans-1);
        request.setAttribute("lastPlan",lastPlan);
        request.setAttribute("numberOfRecipe", recipes);
        request.setAttribute("numberOfPlans", plans);
        return new ModelAndView("dashboard");
    }
}
