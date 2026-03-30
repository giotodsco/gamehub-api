package com.todesco.gamehub.repository;

import com.todesco.gamehub.entity.GameStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameStoreRepository extends JpaRepository<GameStore, Long> {
}
