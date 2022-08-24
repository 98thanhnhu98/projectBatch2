package com.example.Project.Service;

import com.example.Project.model.Authority;

import java.util.List;
import java.util.Optional;

public interface RolePJService {
    List<Authority> getAll();
    void saveClass(Authority room);
    void deleteRoles(long id);
    Optional<Authority> findRolesById(long id);
    Authority getOne(long id);
}
