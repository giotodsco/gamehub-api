package com.todesco.gamehub.dtos.request;

import lombok.Builder;

@Builder
public record JWTUserData(Long id, String name, String email ) {
}
