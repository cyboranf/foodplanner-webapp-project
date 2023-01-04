package com.example.foodplannerproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RegisterController {
    @GetMapping("/registration")
    public String showViewOfRegister() {
        return "register";
    }

}
