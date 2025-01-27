package com.sigma.Controller;


import com.sigma.Model.Category;
import com.sigma.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/saloon/{id}")
    public ResponseEntity<Set<Category>> getCaegoriesBySaloon(@PathVariable Long id){
        Set<Category> categories=categoryService.getAllCategories(id);
        return ResponseEntity.ok(categories);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) throws Exception {
        Category categories=categoryService.getCategoryById(id);
        return ResponseEntity.ok(categories);
    }



}
