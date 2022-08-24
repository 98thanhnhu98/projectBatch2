package com.example.Project.repository;

import com.example.Project.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Authorepo extends JpaRepository<Authority , Long> {
    Authority findByName(String name);
}
