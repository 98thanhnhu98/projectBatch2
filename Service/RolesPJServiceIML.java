package com.example.Project.Service;

import com.example.Project.model.Authority;
import com.example.Project.repository.RolesPJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RolesPJServiceIML implements RolePJService{
    @Autowired
    RolesPJRepository rolesPJRepository;

    @Override
    public List<Authority> getAll() {
        return rolesPJRepository.findAll();
    }

    @Override
    public void saveClass(Authority room) {
        rolesPJRepository.save(room);
    }

    @Override
    public void deleteRoles(long id) {
        rolesPJRepository.deleteById(id);
    }

    @Override
    public Optional<Authority> findRolesById(long id) {
        return rolesPJRepository.findById(id);
    }

    @Override
    public Authority getOne(long id) {
        return rolesPJRepository.findById(id).get();
    }
}
