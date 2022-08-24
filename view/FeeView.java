package com.example.Project.view;

import com.example.Project.Service.FeeServiceIML;
import com.example.Project.model.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FeeView {
    @Autowired
    FeeServiceIML feeServiceIML;

    @GetMapping("/feeall")
    public String showHang(Model model){
        List<Fee> fee = feeServiceIML.getAll();
        model.addAttribute("fee",fee);
        return "/main/resources/templates/fee.html";
    }

    @GetMapping("/fee/{id}")
    public String showdetailRoom(Model model,@PathVariable long id){
        Fee fee = feeServiceIML.getOne(id);
        model.addAttribute("fees",fee);
        return "/main/resources/templates/fee.html";
    }
}
