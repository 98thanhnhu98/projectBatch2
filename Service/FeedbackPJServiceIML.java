package com.example.Project.Service;

import com.example.Project.model.Feedback;
import com.example.Project.repository.FeedbackPJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackPJServiceIML implements FeedbackPJService{
    @Autowired
    FeedbackPJRepository feedbackPJRepository;
    @Override
    public List<Feedback> getAll() {
        return feedbackPJRepository.findAll();
    }

    @Override
    public void saveFeedback(Feedback feedback) {
        feedbackPJRepository.save(feedback);
    }

    @Override
    public void deleteFeedback(long id) {
        feedbackPJRepository.deleteById(id);
    }

    @Override
    public Optional<Feedback> findFeedbackById(long id) {
        return feedbackPJRepository.findById(id);
    }

    @Override
    public Feedback getOne(long id) {
        return feedbackPJRepository.findById(id).get();
    }
}
