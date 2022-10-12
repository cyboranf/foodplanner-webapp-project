package com.example.foodplannerproject.web;


import com.example.foodplannerproject.service.AdminService;
import com.example.foodplannerproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    private final UserService userService;
    private final AdminService adminService;

    public LoginController(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public ModelAndView showForm(){
        return new ModelAndView("login");
    }
}
