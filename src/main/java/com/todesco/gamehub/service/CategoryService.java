package com.todesco.gamehub.service;

import com.todesco.gamehub.entity.Category;
import com.todesco.gamehub.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public List<Category> listAllCategory(){
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category listPerId(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deletePerId(Long id){
        categoryRepository.deleteById(id);
    }
}
