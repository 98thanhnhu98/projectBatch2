package com.example.Project.Service;

import com.example.Project.model.Category;
import com.example.Project.repository.CategoryPJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryPJServiceIML implements CategoryPJService {
    @Autowired
    private CategoryPJRepository categoryPJRepository;

    @Override
    public List<Category> getAll() {
        return categoryPJRepository.findAll();
    }

    @Override
    public void saveCategory(Category categoryPJ) {
        categoryPJRepository.save(categoryPJ);
    }

    @Override
    public void deleteCategory(long id) {
        categoryPJRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findCategoryById(long id) {
        return categoryPJRepository.findById(id);
    }

    @Override
    public Category getOne(long id) {
        return categoryPJRepository.findById(id).get();
    }
}
