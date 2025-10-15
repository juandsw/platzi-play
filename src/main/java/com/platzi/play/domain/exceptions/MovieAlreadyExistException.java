package com.platzi.play.domain.exceptions;

public class MovieAlreadyExistException extends RuntimeException {
    public MovieAlreadyExistException(String movieTitle) {
        super("La película " + movieTitle + " ya existe");
    }
}
