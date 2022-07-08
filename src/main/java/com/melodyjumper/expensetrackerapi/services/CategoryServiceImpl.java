package com.melodyjumper.expensetrackerapi.services;

import java.util.List;

import com.melodyjumper.expensetrackerapi.domain.Category;
import com.melodyjumper.expensetrackerapi.exceptions.EtBadRequestException;
import com.melodyjumper.expensetrackerapi.exceptions.EtResourceNotFoundException;
import com.melodyjumper.expensetrackerapi.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Integer userId, String title, String description) throws EtBadRequestException {
        int categoryId = categoryRepository.create(userId, title, description);
        return categoryRepository.findById(userId, categoryId);
    }

    @Override
    public List<Category> fetchAllCategories(Integer userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
        return categoryRepository.findById(userId, categoryId);
    }

}
