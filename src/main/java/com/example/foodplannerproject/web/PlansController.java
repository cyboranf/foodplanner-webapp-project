package com.example.foodplannerproject.web;

import com.example.foodplannerproject.domain.Plan;
import com.example.foodplannerproject.service.PlanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlansController {
    private final PlanService planService;

    public PlansController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/app/plan/list")
    public String showPlanList(Model model) {
        List<Plan> planList = planService.findAll();
        model.addAttribute("planList", planList);

        return "appPlanList";
    }
}
