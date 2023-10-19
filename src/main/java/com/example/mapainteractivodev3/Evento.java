package com.example.mapainteractivodev3;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    @ManyToOne
    private Lugar lugar;

    // Constructores, getters y setters
}
