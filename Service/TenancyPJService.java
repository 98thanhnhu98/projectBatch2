package com.example.Project.Service;

import com.example.Project.dto.userTenancyRoom;
import com.example.Project.model.Tenancy;

import java.util.List;
import java.util.Optional;

public interface TenancyPJService {
    List<Tenancy> getAll();

    void saveTenancy(Tenancy tenancy);

    void deleteTenancy(long id);

    Optional<Tenancy> findTenancyById(long id);

    Tenancy getOne(long id);

    List<Tenancy> findTenancyByName(String name);

    List<userTenancyRoom> getInfo(long id);
}
