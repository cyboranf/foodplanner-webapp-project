package com.example.foodplannerproject.web;

import com.example.foodplannerproject.domain.Plan;
import com.example.foodplannerproject.domain.Recipe;
import com.example.foodplannerproject.service.PlanService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @GetMapping("/app/plan/add")
    public String showPlanAdd() {
        return "appPlanAdd";
    }

    @PostMapping("/app/plan/add")
    public String savingNewPlan(@RequestParam String planName,
                                @RequestParam String planDescription) {
        Plan newPlan = new Plan();
        LocalDate created = LocalDate.now();
        if (planName.isEmpty() || planDescription.isEmpty()) {
            return "appPlanAdd";
        } else {
            newPlan.setName(planName);
            newPlan.setDescription(planDescription);
            newPlan.setCreated(String.valueOf(created));
            planService.save(newPlan);
            return "redirect:/app/dashboard";
        }
    }

    @GetMapping("/app/plan/details")
    public String showPlanDetails(@RequestParam String id,
                                  Model model) {
        Plan showedPlan = planService.findById(Long.parseLong(id));
        model.addAttribute("plan", showedPlan);

        return "appPlanDetails";
    }

    @GetMapping("/app/plan/edit")
    public String showPlanEditView(@RequestParam String id,
                                   Model model) {
        Plan showedPlan = planService.findById(Long.parseLong(id));
        model.addAttribute("plan", showedPlan);

        return "appPlanEdit";
    }

    @PostMapping("/app/plan/edit")
    public String editPlan(@RequestParam String id,
                           @RequestParam String planName,
                           @RequestParam String planDescription) {
        Plan editedPlan = planService.findById(Long.parseLong(id));

        editedPlan.setName(planName);
        editedPlan.setDescription(planDescription);

        planService.save(editedPlan);
        return "redirect:/app/plan/list";
    }


}
