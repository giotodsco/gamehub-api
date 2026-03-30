package com.todesco.gamehub.mapper;

import com.todesco.gamehub.dtos.request.CategoryRequest;
import com.todesco.gamehub.dtos.response.CategoryResponse;
import com.todesco.gamehub.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest){
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
