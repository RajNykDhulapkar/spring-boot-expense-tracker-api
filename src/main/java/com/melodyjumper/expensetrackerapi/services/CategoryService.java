package com.melodyjumper.expensetrackerapi.services;

import java.util.List;

import com.melodyjumper.expensetrackerapi.domain.Category;
import com.melodyjumper.expensetrackerapi.exceptions.EtBadRequestException;
import com.melodyjumper.expensetrackerapi.exceptions.EtResourceNotFoundException;

public interface CategoryService {
    List<Category> fetchAllCategories(Integer userId);

    Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    Category addCategory(Integer userId, String title, String description) throws EtBadRequestException;

}
