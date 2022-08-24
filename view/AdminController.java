package com.example.Project.view;

import com.example.Project.Service.UsersPJServiceIML;
import com.example.Project.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
    @Autowired
    UsersPJServiceIML UsersPJServiceIML;

//    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
//    public String adminDashbroard(Model model){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//        Users users = UsersPJServiceIML.findUserByEmail2(email);
//        model.addAttribute("users", users);
//        return "admin";
//    }


}
