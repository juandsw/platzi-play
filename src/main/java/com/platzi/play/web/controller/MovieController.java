package com.platzi.play.web.controller;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.SuggestRequestDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.domain.service.MovieService;
import com.platzi.play.domain.service.PlatziPlayAiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "Operations about movies of PlatziPlay")
public class MovieController {

    private final MovieService movieService;
    private final PlatziPlayAiService platziPlayAiService;

    public MovieController(MovieService movieService, PlatziPlayAiService platziPlayAiService) {
        this.movieService = movieService;
        this.platziPlayAiService = platziPlayAiService;

    }

    @GetMapping
    public ResponseEntity<List> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
                summary = "Obtener una película con su identificador",
                description = "Retorna la película que conincida con el identifcador enviado",
                responses = {
                            @ApiResponse(responseCode = "200", description = "Película encontrada"),
                            @ApiResponse(responseCode = "404", description = "Película no encontrada", content = @Content)
                }
                )
    public ResponseEntity<MovieDto> getById(@Parameter(description = "Identificador de la película a recuperar", example = "9") @PathVariable UUID id) {
        MovieDto movieDto = this.movieService.getById(id);

        if (movieDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movieDto);
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.create(movieDto));
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMovieSuggestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(this.platziPlayAiService.generateMoviesSuggestion(suggestRequestDto.userPreferences()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable UUID id, @RequestBody @Valid UpdateMovieDto updateMovieDto) {
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> delete(@PathVariable UUID id) {
        return ResponseEntity.ok(this.movieService.delete(id));
    }
}
