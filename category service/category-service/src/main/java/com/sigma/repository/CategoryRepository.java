package com.sigma.repository;

import com.sigma.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Set<Category> findBySaloonId(Long saloonId);
}
