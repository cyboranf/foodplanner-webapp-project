package com.example.foodplannerproject.web;

import com.example.foodplannerproject.domain.User;
import com.example.foodplannerproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Controller
public class ChangePasswordController {
    private final UserService userService;

    public ChangePasswordController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/app/changePassword")
    public String showChangePasswordJSP() {
        return "appChangePassword";
    }

    @PostMapping("/app/changePassword")
    public String changingPassword(@RequestParam String password1,
                                   @RequestParam String password2,
                                   HttpServletRequest request) {
        AtomicReference<Cookie> cookieEmail = new AtomicReference<>();
        AtomicReference<Cookie> cookieName = new AtomicReference<>();
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        cookies.forEach(c -> {
            if (c.getName().equals("cookieEmail")) {
                cookieEmail.set(c);
            }
        });

        List<User> finalUser = userService.findAll().stream()
                .filter(u -> u.getEmail().equals(cookieEmail.get().getValue()))
                .collect(Collectors.toList());

        User changingUser = finalUser.get(0);

        if (password1.equals(password2)) {
            changingUser.setPassword(password1);
            userService.saveUser(changingUser);
            return "redirect:/app/dashboard";
        } else {
            return "redirect:/app/changePassword";
        }
    }
}
