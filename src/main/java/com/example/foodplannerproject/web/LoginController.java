package com.example.foodplannerproject.web;


import com.example.foodplannerproject.domain.User;
import com.example.foodplannerproject.service.AdminService;
import com.example.foodplannerproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LoginController {
    private final UserService userService;
    private final AdminService adminService;

    public LoginController(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public ModelAndView showForm() {

        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public String useForm(HttpServletRequest request,
                          HttpServletResponse response,
                          @RequestParam String email,
                          @RequestParam String password) {
        List<User> userList = userService.findAll();

        String theEnd = "";
        for (User userF : userList) {
            if (userF.getEmail().equals(email) && userF.getPassword().equals(password)) {
                response.addCookie(new Cookie("cookieName", userF.getFirstname()));
                theEnd = "redirect:/app/dashboard";
                break;
            } else {
                theEnd = "redirect:/login";
            }
        }
        return theEnd;
    }
}
