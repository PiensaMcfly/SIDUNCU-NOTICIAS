package com.siduncu_proyect.siduncuapp.Models;

import com.siduncu_proyect.siduncuapp.Enums.Rol;
import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreUsuario;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol; // ADMIN, EDITOR

}
