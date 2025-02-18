
package com.siduncu_proyect.siduncuapp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author siduncuNotebook
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Imagen {
    //a Primary key for Image 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //url´s to access 
    private String url;
    //Foreign key categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    //Foreign key Noticia
    @ManyToOne
    @JoinColumn(name = "noticia_id")
    private Noticia noticia;
}