package com.todesco.gamehub.dtos.request;

import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record GameRequest(
        @NotEmpty(message = "Nome do jogo é obrigatório.")
        String title,
        String description,
        LocalDate releaseDate,
        BigDecimal price,
        List<Long> categories,
        List<Long> gamestore
) {
}
