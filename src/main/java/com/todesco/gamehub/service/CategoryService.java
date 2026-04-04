package com.todesco.gamehub.service;

import com.todesco.gamehub.dtos.request.CategoryRequest;
import com.todesco.gamehub.dtos.response.CategoryResponse;
import com.todesco.gamehub.entity.Category;
import com.todesco.gamehub.mapper.CategoryMapper;
import com.todesco.gamehub.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> listAllCategory(){
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toResponse)
                .toList();
    }

    public CategoryResponse createCategory(CategoryRequest categoryRequest){
        Category category1 = categoryRepository.save(CategoryMapper.toCategory(categoryRequest));
        CategoryResponse categorySaved = CategoryMapper.toResponse(category1);
        return categorySaved;
    }

    public CategoryResponse listPerId(Long id){
        return CategoryMapper.toResponse(listEntityPerId(id));
    }

    public Category listEntityPerId(Long id){
        return categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category not found"));

    }

    public void deletePerId(Long id){
        categoryRepository.deleteById(id);
    }
}
