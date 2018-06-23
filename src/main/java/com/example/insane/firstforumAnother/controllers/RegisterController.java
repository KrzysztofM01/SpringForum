package com.example.insane.firstforumAnother.controllers;

import com.example.insane.firstforumAnother.models.UserEntity;
import com.example.insane.firstforumAnother.models.forms.RegisterForm;
import com.example.insane.firstforumAnother.models.repositories.UserRepository;
import com.example.insane.firstforumAnother.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterForm registerForm, Model model) {

        if (userService.isUserExistByLogin(registerForm.getLogin())) {
            model.addAttribute("info", "Login is already occupied");
            return "register";
        }

        userService.registerUser(registerForm);
        return "redirect:/login";

    }
}
