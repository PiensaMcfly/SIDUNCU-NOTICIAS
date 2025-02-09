package com.siduncu_proyect.siduncuapp.Models;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
    @Lob//notacion para texto largo
    @Column(name = "contenido", columnDefinition = "LONGTEXT") 
    private String contenido;
    private LocalDate fechaCreacion;
    private LocalDate fechaPublicacion;
    private boolean publicada;

    @ManyToOne
    private Categoria categoria;
    private String imagenUrl;

}
