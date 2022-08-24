package com.example.Project.Service;

import com.example.Project.model.Fee;
import com.example.Project.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FeeServiceIML implements FeeService{
    @Autowired
    FeeRepository feeRepository;
    @Override
    public List<Fee> getAll() {
        return feeRepository.findAll();
    }

    @Override
    public void saveFee(Fee fee) {
        feeRepository.save(fee);
    }

    @Override
    public void deleteFee(long id) {
        feeRepository.deleteById(id);
    }

    @Override
    public Optional<Fee> findFeeById(long id) {
        return feeRepository.findById(id);
    }

    @Override
    public Fee getOne(long id) {
        Optional<Fee> Fee = feeRepository.findById(id);
        if (Fee.isPresent()){
            return Fee.get();
        }
        throw new RuntimeException("Fee is not found for the id : " + id);
    }

}
