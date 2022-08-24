package com.example.Project.view;

import com.example.Project.Service.TenancyPJService;
import com.example.Project.dto.ListTenancyPJ;
import com.example.Project.model.Tenancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api")
public class TenancyView {
    @Autowired
    TenancyPJService tenancyPJService;

    @GetMapping("/Tenancy")
    public String showHang(Model model){
        List<Tenancy> tenancieOne = tenancyPJService.getAll();
        model.addAttribute("tenancies1",tenancieOne);
        return "Tenancy-html";
    }

    @GetMapping("/Tenancy/{id}")
    public String showdetailHopDong(Model model,@PathVariable long id){
        Tenancy tenancies = tenancyPJService.getOne(id);
        model.addAttribute("tenancies",tenancies);
        return "Tenancy-html";
    }

    @GetMapping("/addTenancy")
    public String addOrEditTenancy(ModelMap model){
        Tenancy tenancy = new Tenancy();
        model.addAttribute("tenancys",tenancy);
        return "Tenancyadd";
    }

    @PostMapping(path = "/actiontwo")
    public String savetenancy(@Valid Tenancy tenancy){
        tenancyPJService.saveTenancy(tenancy);
        return "redirect:/api/Tenancy";
    }
}
