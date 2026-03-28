package com.todesco.gamehub.repository;

import com.todesco.gamehub.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
