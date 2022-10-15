package com.example.foodplannerproject.web;


import com.example.foodplannerproject.domain.Admin;
import com.example.foodplannerproject.domain.User;
import com.example.foodplannerproject.service.AdminService;
import com.example.foodplannerproject.service.UserService;
import com.sun.istack.NotNull;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegisterController {
    private final UserService userService;
    private final AdminService adminService;

    public RegisterController(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }

    @GetMapping("/registration")
    public ModelAndView showForm() {
        return new ModelAndView("register");
    }

    @PostMapping("/registration")
    public String submit(@RequestParam String name, @RequestParam String surname,
                         @RequestParam String email, @RequestParam String password,
                         HttpServletRequest request, @NotNull HttpServletResponse response) {
        User user = new User();

        user.setFirstname(name);
        user.setLastName(surname);
        user.setEmail(email);
        user.setPassword(password);
        userService.saveUser(user);


        User user1 = userService.findById(1L);
        Admin admin = new Admin();
        admin.setFirstname(user1.getFirstname());
        admin.setLastName(user1.getLastName());
        admin.setEmail(user1.getEmail());
        admin.setPassword(user1.getPassword());
        adminService.save(admin);


        return "redirect:/login";
    }
}
