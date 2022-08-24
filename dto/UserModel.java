package com.example.Project.dto;

import com.example.Project.model.Authority;
import lombok.Data;

@Data
public class UserModel {
    private String email;
    private String password;
    private Authority authority;
}
