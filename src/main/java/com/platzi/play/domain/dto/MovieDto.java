package com.platzi.play.domain.dto;

import com.platzi.play.domain.Genre;
import com.platzi.play.domain.State;

import java.time.LocalDate;
import java.util.UUID;

public record MovieDto(
        UUID id,
        String title,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating,
        State state
) {
}
