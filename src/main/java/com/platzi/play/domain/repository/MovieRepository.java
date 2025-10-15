package com.platzi.play.domain.repository;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.UpdateMovieDto;

import java.util.List;
import java.util.UUID;


public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(UUID id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(UUID id, UpdateMovieDto updateMovieDto);
    MovieDto delete(UUID id);

}
