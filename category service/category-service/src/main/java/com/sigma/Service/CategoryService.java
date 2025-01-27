package com.sigma.Service;

import com.sigma.Model.Category;
import com.sigma.saloon.service.payload.DTO.SaloonDTO;

import java.util.Set;

public interface CategoryService {
    Category saveCategory(Category category, SaloonDTO saloonDTO);
    Set<Category> getAllCategories(Long id);
    Category getCategoryById(Long id) throws Exception;
    void deleteCategoryById(Long id,Long saloonId) throws Exception;


}
