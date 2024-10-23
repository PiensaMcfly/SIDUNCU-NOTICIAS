package com.siduncu_proyect.siduncuapp.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String contenido;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaPublicacion;
    private boolean publicada;

    @ManyToOne
    private Categoria categoria;

    @OneToOne
    private Imagen imagenUrl;

}
