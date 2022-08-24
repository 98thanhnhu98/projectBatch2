package com.example.Project.view;

import com.example.Project.Service.CategoryPJService;
import com.example.Project.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class CategoryView {
    @Autowired
    CategoryPJService categoryPJService;

    @GetMapping("/Category")
    public String showHang(Model model){
        List<Category> tenancies = categoryPJService.getAll();
        model.addAttribute("tenancies",tenancies);
        return "/main/resources/static/Categoryshtml.html";
    }
}
