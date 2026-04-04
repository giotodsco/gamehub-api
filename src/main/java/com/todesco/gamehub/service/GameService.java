package com.todesco.gamehub.service;

import com.todesco.gamehub.dtos.request.GameRequest;
import com.todesco.gamehub.dtos.response.GameResponse;
import com.todesco.gamehub.entity.Category;
import com.todesco.gamehub.entity.Game;
import com.todesco.gamehub.mapper.GameMapper;
import com.todesco.gamehub.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final CategoryService categoryService;

    public GameResponse createGame(GameRequest gameRequest){
        Game game = GameMapper.toGame(gameRequest);

        List<Category> validatedCategories = findCategories(game.getCategories());
        game.setCategories(validatedCategories);

        gameRepository.save(game);
        return GameMapper.toResponse(game);
    }

    public List<GameResponse> listAll(){
        return gameRepository.findAll()
                .stream()
                .map(GameMapper::toResponse)
                .toList();
    }

    public GameResponse findById(Long id){
        Game game = gameRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Game not found"));
        return GameMapper.toResponse(game);
    }

    public void deleteById(Long id){
        gameRepository.deleteById(id);
    }

    public List<Category> findCategories(List<Category> categories){
        return categories.stream()
                .map(category -> categoryService.listEntityPerId(category.getId()))
                .toList();
    }






}
