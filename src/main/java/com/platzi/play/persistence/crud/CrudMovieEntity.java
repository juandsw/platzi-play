package com.platzi.play.persistence.crud;

import com.platzi.play.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, UUID> {
}
