package com.example.Project.dto;

import com.example.Project.model.Users;

import java.util.Optional;

public class ListOne {
    private Optional<Users> data;

    public Optional<Users> getData() {
        return data;
    }

    public void setData(Optional<Users> data) {
        this.data = data;
    }
}
