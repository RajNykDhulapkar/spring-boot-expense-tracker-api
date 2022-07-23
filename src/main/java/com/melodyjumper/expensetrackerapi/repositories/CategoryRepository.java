package com.melodyjumper.expensetrackerapi.repositories;

import java.util.List;

import com.melodyjumper.expensetrackerapi.domain.Category;
import com.melodyjumper.expensetrackerapi.exceptions.EtBadRequestException;
import com.melodyjumper.expensetrackerapi.exceptions.EtResourceNotFoundException;

public interface CategoryRepository {
    List<Category> findAll(Integer userId) throws EtResourceNotFoundException;

    Category findById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    Integer create(Integer userId, String title, String description) throws EtBadRequestException;

    void update(Integer userId, Integer categoryId, Category category) throws EtBadRequestException;

    void removeById(Integer userId, Integer categoryId);

}
