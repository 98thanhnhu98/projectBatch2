package com.example.Project.repository;

import com.example.Project.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackPJRepository extends JpaRepository<Feedback, Long> {

}
