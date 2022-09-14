package com.example.bmi_calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/calculateBMI")
    public String bmiPage(@RequestParam("height") double height, @RequestParam("weight") double weight,
                          RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("weight",weight);
        redirectAttributes.addAttribute("height",height);
        return "redirect:/calculateBMI";
    }

    @GetMapping("/calculateBMI")
    public String makeBMIPage(@RequestParam("height") double height, @RequestParam("weight") double weight,
                              Model model){
        double bmi = (weight/((height/100)*(height/100)));
        model.addAttribute("weight", weight);
        model.addAttribute("height", height);
        model.addAttribute("bmi", bmi);
        return "resultPage";
    }
}
