
package com.siduncu_proyect.siduncuapp.Services;

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
    private IusuarioRepository usuarioRepo;
    
    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
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
    
    
   
}
