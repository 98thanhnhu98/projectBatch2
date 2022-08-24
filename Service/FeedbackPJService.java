package com.example.Project.Service;

import com.example.Project.model.Feedback;

import java.util.List;
import java.util.Optional;

public interface FeedbackPJService {
    List<Feedback> getAll();
    void saveFeedback(Feedback feedback);
    void deleteFeedback(long id);
    Optional<Feedback> findFeedbackById(long id);
    Feedback getOne(long id);
}
