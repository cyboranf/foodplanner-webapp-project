package com.example.foodplannerproject.web;

import com.example.foodplannerproject.domain.User;
import com.example.foodplannerproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showViewOfRegister() {
        return "register";
    }

    @PostMapping("/registration")
    public String createAnAccount(@RequestParam String name,
                                  @RequestParam String surname,
                                  @RequestParam String email,
                                  @RequestParam String password,
                                  @RequestParam String repassword) {
        if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return "register";
        } else if (!password.equals(repassword)) {
            return "register";
        } else {
            User user = new User();
            user.setFirstname(name);
            user.setLastName(surname);
            user.setEmail(email);
            user.setPassword(password);

            userService.saveUser(user);
            return "redirect:/login";
        }
    }
}
