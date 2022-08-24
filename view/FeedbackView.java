package com.example.Project.view;

import com.example.Project.Service.FeedbackPJService;
import com.example.Project.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class FeedbackView {
    @Autowired
    FeedbackPJService feedbackPJService;

    @GetMapping("/Feedback")
    public String showHang(Model model){
        List<Feedback> feedbacks = feedbackPJService.getAll();
        model.addAttribute("feedbacks",feedbacks);
        return "Feedback";
    }
}
