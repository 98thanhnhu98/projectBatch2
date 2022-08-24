package com.example.Project.Service;


import com.example.Project.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryPJService {
    List<Category> getAll();

    void saveCategory(Category categoryPJ);

    void deleteCategory(long id);

    Optional<Category> findCategoryById(long id);

    Category getOne(long id);
}
