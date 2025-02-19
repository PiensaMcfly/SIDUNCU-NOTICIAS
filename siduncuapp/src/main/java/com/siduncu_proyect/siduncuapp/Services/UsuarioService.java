
package com.siduncu_proyect.siduncuapp.Services;

import com.siduncu_proyect.siduncuapp.Enums.Rol;
import com.siduncu_proyect.siduncuapp.Models.Usuario;
import com.siduncu_proyect.siduncuapp.Repositories.IusuarioRepository;
import java.util.List;
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
    public Usuario saveUsuario(@org.jetbrains.annotations.NotNull Usuario usuario2) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(usuario2.getNombreUsuario());
        usuario.setPassword(this.passwordEncoder.encode(usuario2.getPassword())); // Encripta la contraseña

        // Asigna ADMIN si no se proporciona un rol
        if (usuario2.getRol() == null) {
            usuario.setRol(Rol.ADMIN);
        } else {
            usuario.setRol(usuario2.getRol());
        }

        return usuarioRepo.save(usuario); // Guarda el objeto actualizado
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

    @Override
    public Usuario buscarPorNombreUsuario(String nombreUsuario) {
        return usuarioRepo.buscarPorUsuario(nombreUsuario);
    }
    @Override
    public boolean verificarPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);

    }
}
