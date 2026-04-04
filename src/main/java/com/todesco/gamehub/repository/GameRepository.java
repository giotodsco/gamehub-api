package com.todesco.gamehub.repository;

import com.todesco.gamehub.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
