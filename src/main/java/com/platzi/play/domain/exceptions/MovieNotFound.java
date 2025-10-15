package com.platzi.play.domain.exceptions;

import java.util.UUID;

public class MovieNotFound extends RuntimeException {
    public MovieNotFound(UUID id) {
        super("La película " + id + " no existe");
    }
}
