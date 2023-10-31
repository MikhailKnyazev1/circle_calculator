package com.example.circle_calculator.controller;

import com.example.circle_calculator.entity.Circle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CircleController {

    @GetMapping("/circle")
    public String showForm(Model model) {
        if (!model.containsAttribute("circle")) {
            model.addAttribute("circle", new Circle());
        }
        return "circle-form";
    }

    @PostMapping("/circle/calculate")
    public String calculate(@ModelAttribute Circle circle, RedirectAttributes redirectAttributes) {
        Double radius = circle.getRadius();
        Double diameter = circle.getDiameter();

        if (radius == null && diameter != null) {
            radius = diameter / 2;
        }

        if (radius != null) {
            double area = Math.PI * Math.pow(radius, 2);
            double perimeter = 2 * Math.PI * radius;
            circle.setArea(area);
            circle.setPerimeter(perimeter);
            redirectAttributes.addFlashAttribute("circle", circle);
        }

        return "redirect:/circle";
    }
}