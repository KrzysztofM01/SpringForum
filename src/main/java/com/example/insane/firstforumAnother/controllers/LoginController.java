package com.example.insane.firstforumAnother.controllers;

import com.example.insane.firstforumAnother.models.forms.LoginForm;
import com.example.insane.firstforumAnother.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm, Model model) {

        if (userService.loginUser(loginForm)) {
            return "redirect:/index";
        }
        model.addAttribute("info", "Cannot login with your input.");
        return "/login";
    }
}