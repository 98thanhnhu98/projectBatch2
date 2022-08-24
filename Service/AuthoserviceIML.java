package com.example.Project.Service;

import com.example.Project.model.Authority;
import com.example.Project.repository.Authorepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoserviceIML implements Authoservice{
    @Autowired
    Authorepo authorepo;

    @Override
    public Authority findByName(String name) {
        return authorepo.findByName(name);
    }
}
