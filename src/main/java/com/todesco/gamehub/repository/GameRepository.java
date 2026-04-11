package com.todesco.gamehub.repository;

import com.todesco.gamehub.entity.Category;
import com.todesco.gamehub.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findGameByCategoriesIn(List<Category> categories);
}
