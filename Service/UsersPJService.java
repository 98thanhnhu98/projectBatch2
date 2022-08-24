package com.example.Project.Service;

import com.example.Project.dto.userTenancyRoom;
import com.example.Project.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersPJService {
    List<Users> getAll();

    void saveUsers(Users tblClass);

    void deleteUsers(long id);

    Optional<Users> findUsersById(long id);

    Users getOne(long id);
    Users findUserByEmail2(String email);

    Optional<Users> findUserByEmail(String email);
    List<Users> findUsersByName(String name);

    List<Users> getNameBykeyWord(String name);

}
