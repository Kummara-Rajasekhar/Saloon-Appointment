package com.sigma.Controller;

import com.sigma.Model.Category;
import com.sigma.Service.CategoryService;
import com.sigma.saloon.service.payload.DTO.SaloonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories/saloon-owner")
public class SaloonCategoryController {


    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1l);
        Category categories=categoryService.saveCategory(category,saloonDTO);
        return ResponseEntity.ok(categories);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws Exception {
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1l);
        categoryService.deleteCategoryById(id,saloonDTO.getId());
        return ResponseEntity.ok("Catogory Deleted Successfully");
    }
}
