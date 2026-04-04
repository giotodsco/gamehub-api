package com.todesco.gamehub.mapper;

import com.todesco.gamehub.dtos.request.GameRequest;
import com.todesco.gamehub.dtos.response.CategoryResponse;
import com.todesco.gamehub.dtos.response.GameResponse;
import com.todesco.gamehub.dtos.response.GameStoreResponse;
import com.todesco.gamehub.entity.Category;
import com.todesco.gamehub.entity.Game;
import com.todesco.gamehub.entity.GameStore;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class GameMapper {

    public static Game toGame(GameRequest gameRequest){

        List<Category> categories = gameRequest.categories()
                .stream()
                .map(categoryId -> Category.builder().
                        id(categoryId).build())
                .toList();
        List<GameStore> gameStores = gameRequest.gamestore()
                .stream()
                .map(gameStoreId -> GameStore.builder()
                        .id(gameStoreId).build())
                .toList();

        return Game.builder()
                .title(gameRequest.title())
                .description(gameRequest.description())
                .releaseDate(gameRequest.releaseDate())
                .price(gameRequest.price())
                .categories(categories)
                .gameStores(gameStores)
                .build();
    }

    public static GameResponse toResponse(Game game){

        List<CategoryResponse> categories = game.getCategories().stream()
                .map(CategoryMapper::toResponse)
                .toList();
        List<GameStoreResponse> gameStore = game.getGameStores().stream()
                .map(GameStoreMapper::toResponse)
                .toList();

        return GameResponse.builder()
                .id(game.getId())
                .title(game.getTitle())
                .releaseDate(game.getReleaseDate())
                .price(game.getPrice())
                .categories(categories)
                .gamestores(gameStore)
                .build();
    }
}
