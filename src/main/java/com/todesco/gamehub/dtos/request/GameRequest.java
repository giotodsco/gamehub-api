package com.todesco.gamehub.dtos.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record GameRequest(
        String title,
        String description,
        LocalDate releaseDate,
        BigDecimal price,
        List<Long> categories,
        List<Long> gamestore
) {
}
