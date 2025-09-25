package com.platzi.play.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "peliculas")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 150, unique = true)
    private String titulo;

    @Column(nullable = false, precision = 3)
    private Integer duracion;

    @Column(nullable = false, length = 40)
    private String genero;

    @Column(name = "fecha_estreno")
    private LocalDate fechaEstreno;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal clasificacion;

    @Column(nullable = false, length = 1)
    private String estado;

}

