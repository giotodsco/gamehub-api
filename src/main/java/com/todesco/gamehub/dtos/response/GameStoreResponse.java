package com.todesco.gamehub.dtos.response;

import lombok.Builder;

@Builder
public record GameStoreResponse(Long id, String name){
}
