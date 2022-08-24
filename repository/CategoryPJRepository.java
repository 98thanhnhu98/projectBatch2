package com.example.Project.repository;


import com.example.Project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryPJRepository extends JpaRepository<Category, Long> {
}
