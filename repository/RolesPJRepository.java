package com.example.Project.repository;

import com.example.Project.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesPJRepository extends JpaRepository<Authority,Long> {

}
