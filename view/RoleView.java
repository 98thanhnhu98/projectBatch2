package com.example.Project.view;

import com.example.Project.Service.RolePJService;
import com.example.Project.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class RoleView {
    @Autowired
    RolePJService rolePJService;

    @GetMapping("/Roles")
    public String showHang(Model model){
        List<Authority> roles = rolePJService.getAll();
        model.addAttribute("roles",roles);
        return "/main/resources/static/Roles-html.html";
    }
}
