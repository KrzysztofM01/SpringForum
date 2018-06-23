package com.example.insane.firstforumAnother.controllers;

import com.example.insane.firstforumAnother.models.UserEntity;
import com.example.insane.firstforumAnother.models.forms.LoginForm;
import com.example.insane.firstforumAnother.models.forms.MessageForm;
import com.example.insane.firstforumAnother.models.forms.RegisterForm;
import com.example.insane.firstforumAnother.models.repositories.UserRepository;
import com.example.insane.firstforumAnother.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;


    @ModelAttribute
    public void addModel(Model model) {
        model.addAttribute("user", userService);
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("messageForm", new MessageForm());
        return "/index";
    }

    @PostMapping("/index")
    public String index(@ModelAttribute MessageForm messageForm, Model model) {
        return "redirect:/index";

    }


}
