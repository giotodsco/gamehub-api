package com.todesco.gamehub.dtos.request;


import jakarta.validation.constraints.NotEmpty;

public record GameStoreRequest(
        @NotEmpty(message = "Nome da GameStore é obrigatório.")
        String name) {
}
