package com.todesco.gamehub.mapper;


import com.todesco.gamehub.dtos.request.GameStoreRequest;
import com.todesco.gamehub.dtos.response.GameStoreResponse;
import com.todesco.gamehub.entity.GameStore;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GameStoreMapper {
    public static GameStore toRequest(GameStoreRequest gameStoreRequest){
        return GameStore
                .builder()
                .name(gameStoreRequest.name())
                .build();
    }

    public static GameStoreResponse toResponse(GameStore gameStore){
        return GameStoreResponse
                .builder()
                .id(gameStore.getId())
                .name(gameStore.getName())
                .build();
    }
}
