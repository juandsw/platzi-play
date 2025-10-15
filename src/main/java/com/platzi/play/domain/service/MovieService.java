package com.platzi.play.domain.service;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Tool("Busca todas las películas que existen dentro de la plataforma")
    public List<MovieDto> getAll() {
        return movieRepository.getAll();
    }

    public MovieDto getById(UUID id) {
        return this.movieRepository.getById(id);
    }

    public MovieDto create(MovieDto movieDto) {
        return this.movieRepository.save(movieDto);
    }

    public MovieDto update(UUID id, UpdateMovieDto updateMovieDto) {
        return this.movieRepository.update(id, updateMovieDto);

    }

    public MovieDto delete(UUID id) {
        return this.movieRepository.delete(id);
    }
}
