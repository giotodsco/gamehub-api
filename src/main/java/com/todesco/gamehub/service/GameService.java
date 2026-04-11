package com.todesco.gamehub.service;

import com.todesco.gamehub.dtos.request.GameRequest;
import com.todesco.gamehub.dtos.response.CategoryResponse;
import com.todesco.gamehub.dtos.response.GameResponse;
import com.todesco.gamehub.entity.Category;
import com.todesco.gamehub.entity.Game;
import com.todesco.gamehub.entity.GameStore;
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
    private final GameStoreService gameStoreService;

    public GameResponse createGame(GameRequest gameRequest){
        Game game = GameMapper.toGame(gameRequest);

        List<Category> validatedCategories = findCategories(game.getCategories());
        game.setCategories(validatedCategories);

        List<GameStore> validatedGameStore = findGamestore(game.getGameStores());
        game.setGameStores(validatedGameStore);

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

    public List<GameStore> findGamestore(List<GameStore> gameStores){
        return gameStores.stream()
                .map(gameStore -> gameStoreService.listEntityPerId(gameStore.getId()))
                .toList();
    }

    public GameResponse updateGame(Long id, GameRequest request){
        Game game = gameRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Game not found"));
        Game games = GameMapper.toGame(request);

        List<Category> categories =
                findCategories(games.getCategories());

        List<GameStore> gameStores =
                findGamestore(games.getGameStores());

        game.setTitle(games.getTitle());
        game.setDescription(games.getDescription());
        game.setPrice(games.getPrice());
        game.setReleaseDate(games.getReleaseDate());

        game.getGameStores().clear();
        game.getGameStores().addAll(gameStores);

        game.getCategories().clear();
        game.getCategories().addAll(categories);

        gameRepository.save(game);

        return GameMapper.toResponse(game);
    }

    public List<GameResponse> listPerCategory(Long id){
        return gameRepository.findGameByCategoriesIn(List.of(Category.builder().id(id).build()))
                .stream()
                .map(GameMapper::toResponse)
                .toList();
    }
}
