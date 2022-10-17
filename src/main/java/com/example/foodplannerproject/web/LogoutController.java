package com.example.foodplannerproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogoutController {
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies=request.getCookies();
        for (Cookie cookie:cookies){
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }


        return "redirect:/";
    }
}
