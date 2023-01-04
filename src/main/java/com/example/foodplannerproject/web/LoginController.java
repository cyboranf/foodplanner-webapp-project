package com.example.foodplannerproject.web;


import com.example.foodplannerproject.domain.User;
import com.example.foodplannerproject.service.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String logInApp(@RequestParam String email,
                           @RequestParam String password,
                           HttpServletResponse response) {
        if (email.isEmpty() || password.isEmpty()) {
            return "login";
        } else {
            List<User> userList = userService.findAll();

            List<User> loginUser = userList.stream().
                    filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                    .collect(Collectors.toList());

            User finalUser = loginUser.get(0);
            Cookie cookieName = new Cookie("cookieName", finalUser.getFirstname());
            response.addCookie(cookieName);

            return "redirect:/app/dashboard";
        }
    }

}
