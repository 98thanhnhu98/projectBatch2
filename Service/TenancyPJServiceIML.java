package com.example.Project.Service;

import com.example.Project.dto.userTenancyRoom;
import com.example.Project.model.Tenancy;
import com.example.Project.repository.TenancyPJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenancyPJServiceIML implements TenancyPJService{
    @Autowired
    TenancyPJRepository tenancyPJRepository;
    @Override
    public List<Tenancy> getAll() {
        return tenancyPJRepository.findAll();
    }

    @Override
    public void saveTenancy(Tenancy tenancy) {
        tenancyPJRepository.save(tenancy);
    }

    @Override
    public void deleteTenancy(long id) {
        tenancyPJRepository.deleteById(id);
    }

    @Override
    public Optional<Tenancy> findTenancyById(long id) {
        return tenancyPJRepository.findById(id);
    }

    @Override
    public Tenancy getOne(long id) {
        return tenancyPJRepository.findById(id).get();
    }

    @Override
    public List<Tenancy> findTenancyByName(String name) {
        return null;
    }

        @Override
    public List<userTenancyRoom> getInfo(long id) {
        return tenancyPJRepository.getInformation(id);
    }
}
