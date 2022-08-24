package com.example.Project.Service;


import com.example.Project.model.Users;
import com.example.Project.repository.UsersPJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersPJServiceIML implements UsersPJService {
    @Autowired
    UsersPJRepository usersPJRepository;

    @Override
    public List<Users> getAll() {
        return usersPJRepository.findAll();
    }

    @Override
    public void saveUsers(Users users) {
        usersPJRepository.save(users);
    }

    @Override
    public void deleteUsers(long id) {
        usersPJRepository.deleteById(id);
    }

    @Override
    public Optional<Users> findUsersById(long id) {
        return usersPJRepository.findById(id);
    }

    @Override
    public Users getOne(long id) {
        Optional<Users> users = usersPJRepository.findById(id);
        if (users.isPresent()){
            return users.get();
        }
        throw new RuntimeException("User is not found for the id : " + id);
    }

    @Override
    public Users findUserByEmail2(String email) {
        return usersPJRepository.findUsersByEmail(email);
    }

    @Override
    public Optional<Users> findUserByEmail(String email) {
        return usersPJRepository.findByEmail(email);
    }

    @Override
    public List<Users> findUsersByName(String name) {
        return usersPJRepository.findUsersByFullname(name);
    }

    @Override
    public List<Users> getNameBykeyWord(String name) {
        return usersPJRepository.findByFullnameContaining(name);
    }

//    @Override
//    public List<userTenancyRoom> getInfo(long id) {
//        return usersPJRepository.getInformation(id);
//    }
}
