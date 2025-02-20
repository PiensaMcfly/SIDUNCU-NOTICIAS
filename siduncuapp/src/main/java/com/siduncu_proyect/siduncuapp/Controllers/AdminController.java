package com.siduncu_proyect.siduncuapp.Controllers;

import com.siduncu_proyect.siduncuapp.Models.Usuario;
import com.siduncu_proyect.siduncuapp.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UsuarioService usuarioService; // Tu servicio para manejar usuarios

    @PostMapping("/crear-usuario")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
        usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok("Usuario creado con éxito.");
    }
}