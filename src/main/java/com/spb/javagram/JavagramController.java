package com.spb.javagram;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class JavagramController {
    List<User> users = new ArrayList<>();
    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }
    
    @GetMapping("/result")
    public String getResult(Model model) {
        model.addAttribute("users", users);
        return "result";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(User user, BindingResult result) {
        if (result.hasErrors()) return "form";
        return "redirect:/result";
    }
    


}
