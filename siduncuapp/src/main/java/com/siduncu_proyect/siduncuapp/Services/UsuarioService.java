
package com.siduncu_proyect.siduncuapp.Services;

import com.siduncu_proyect.siduncuapp.Enums.Rol;
import com.siduncu_proyect.siduncuapp.Models.Usuario;
import com.siduncu_proyect.siduncuapp.Repositories.IusuarioRepository;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author siduncuNotebook
 */
@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    
    @Autowired
    private IusuarioRepository usuarioRepo;
    
    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario saveUsuario(@NotNull Usuario usuarioInput) {
        // Validar si el nombre de usuario ya existe en la base de datos
        if (usuarioInput.getNombreUsuario() != null && usuarioRepo.FindByNombreUsuario(usuarioInput.getNombreUsuario()) != null) {
            throw new IllegalArgumentException("El nombre de usuario ya está en uso.");
        }

        // Crear una nueva instancia de Usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(usuarioInput.getNombreUsuario());

        // Codificar la contraseña
        usuario.setPassword(passwordEncoder.encode(usuarioInput.getPassword()));

        // Asignar el rol, si no se proporciona, asignar un rol por defecto (opcional)
        if (usuarioInput.getRol() == null) {
            usuario.setRol(Rol.EDITOR); // Asigna un rol estándar como "EDITOR"
        } else {
            usuario.setRol(usuarioInput.getRol());
        }

        // Guardar el usuario en la base de datos
        return usuarioRepo.save(usuario);
    }


    @Override
    public void deleteUsuario(Long id) {
        try {
            
            usuarioRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }

    @Override
    public Usuario findUsuario(Long id) {
        return usuarioRepo.findById(id).orElse(null);
        }

    @Override
    public void updateUsuario(Usuario usuario) {
        try {
            usuarioRepo.save(usuario);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void validarPassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres.");
        }
        if (!password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("La contraseña debe contener al menos un número.");
        }
        if (!password.matches(".*[A-Za-z].*")) {
            throw new IllegalArgumentException("La contraseña debe contener al menos una letra.");
        }
        // Puedes agregar más reglas aquí
    }


}
