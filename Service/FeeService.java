package com.example.Project.Service;

import com.example.Project.model.Fee;

import java.util.List;
import java.util.Optional;

public interface FeeService {
    List<Fee> getAll();
    void saveFee(Fee fee);
    void deleteFee(long id);
    Optional<Fee> findFeeById(long id);
    Fee getOne(long id);
}
