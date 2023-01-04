package com.example.foodplannerproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/app/dashboard")
    public String viewOfDashboardJsp() {
        return "dashboard";
    }
}
