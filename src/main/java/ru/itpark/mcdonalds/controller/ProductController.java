package ru.itpark.mcdonalds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itpark.mcdonalds.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("items", service.getAll());
        return "all";
    }


}
