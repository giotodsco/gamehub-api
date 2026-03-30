package com.todesco.gamehub.service;

import com.todesco.gamehub.dtos.request.CategoryRequest;
import com.todesco.gamehub.dtos.request.GameStoreRequest;
import com.todesco.gamehub.dtos.response.CategoryResponse;
import com.todesco.gamehub.dtos.response.GameStoreResponse;
import com.todesco.gamehub.entity.Category;
import com.todesco.gamehub.entity.GameStore;
import com.todesco.gamehub.mapper.CategoryMapper;
import com.todesco.gamehub.mapper.GameStoreMapper;
import com.todesco.gamehub.repository.CategoryRepository;
import com.todesco.gamehub.repository.GameStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameStoreService {
    private GameStoreRepository gameStoreRepository;

    public List<GameStoreResponse> listAll(){
        return gameStoreRepository.findAll().stream()
                .map(GameStoreMapper::toResponse)
                .toList();
    }

    public GameStoreResponse createGameStore(GameStoreRequest gameStoreRequest){
        GameStore gameStore = gameStoreRepository.save(GameStoreMapper.toRequest(gameStoreRequest));
        return GameStoreMapper.toResponse(gameStore);
    }

    public GameStoreResponse listPerId(Long id){
        GameStore idStore = gameStoreRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Store not found"));
        return GameStoreMapper.toResponse(idStore);
    }

    public void deletePerId(Long id){
        gameStoreRepository.deleteById(id);
    }
}
