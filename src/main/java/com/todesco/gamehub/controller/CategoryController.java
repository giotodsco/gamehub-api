package com.todesco.gamehub.controller;

import com.todesco.gamehub.entity.Category;
import com.todesco.gamehub.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamehub/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/find/all")
    public ResponseEntity<List<Category>> listAllCategory(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.listAllCategory());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Category> listPerId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.listPerId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(category));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deletePerId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
