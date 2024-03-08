package com.califfod.bizsoft.firstclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller("/user")
public class TestController {

    @Autowired
    UserRepository repository;

    @GetMapping
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
        model.addAttribute("listProfession", listProfession);

        return "dashboard";
    }

    @PostMapping("/register")
    @ResponseBody
    public String submitForm(@ModelAttribute("user") User user) {
        return repository.save(user).toString();
    }

    @GetMapping("/all-user")
    @ResponseBody
    public List<User> getAll(@ModelAttribute("user") User user) {
        return repository.findAll();
    }
}
