package com.example.mapainteractivodev3;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String departamento;
    private String municipio;

    @OneToMany(mappedBy = "lugar")
    private List<Evento> eventos;

    // Espacio para constructores, getters, setters etc etc
}
