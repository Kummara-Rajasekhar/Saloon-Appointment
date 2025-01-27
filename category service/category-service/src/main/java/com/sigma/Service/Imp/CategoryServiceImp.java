package com.sigma.Service.Imp;

import com.sigma.Model.Category;
import com.sigma.Service.CategoryService;
import com.sigma.repository.CategoryRepository;
import com.sigma.saloon.service.payload.DTO.SaloonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {


    private final CategoryRepository categoryRepository;
    @Override
    public Category saveCategory(Category category, SaloonDTO saloonDTO) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setSaloonId(saloonDTO.getId());
        newCategory.setImage(category.getImage());
        return categoryRepository.save(newCategory);
    }

    @Override
    public Set<Category> getAllCategories(Long id) {
        return categoryRepository.findBySaloonId(id);
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
        Category category = categoryRepository.findById(id).orElse(null);
        if(category == null){
            throw  new Exception("Category not exist with id"+id);
        }
        return category;
    }

    @Override
    public void deleteCategoryById(Long id,Long saloonId) throws Exception {
        Category category = getCategoryById(id);
        if(!category.getSaloonId().equals(saloonId)){
            throw  new Exception("You don't have permission to delete this category");
        }
        categoryRepository.delete(category);



    }
}
