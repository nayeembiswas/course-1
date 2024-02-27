package com.califfod.bizsoft.firstclass;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {

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
        System.out.println(user);
        return user.toString();
    }
}
