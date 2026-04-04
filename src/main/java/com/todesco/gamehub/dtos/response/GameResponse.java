package com.todesco.gamehub.dtos.response;


import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
public record GameResponse(
        Long id,
        String title,
        LocalDate releaseDate,
        BigDecimal price,
        List<CategoryResponse> categories,
        List<GameStoreResponse> gamestores
) {
}
