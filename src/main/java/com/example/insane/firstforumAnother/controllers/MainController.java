package com.example.insane.firstforumAnother.controllers;

import com.example.insane.firstforumAnother.models.forms.MessageForm;
import com.example.insane.firstforumAnother.models.services.MessageService;
import com.example.insane.firstforumAnother.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    MessageService messageService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("messageForm", new MessageForm());
        messageService.loadMessagesToList();
        model.addAttribute("messageList", messageService.getMessageList());
        return "/index";
    }

    @PostMapping("/index")
    public String index(@ModelAttribute MessageForm messageForm) {
        messageService.saveMessage(userService.getUserEntity().getId(), messageForm);
        return "redirect:/index";
    }


}
