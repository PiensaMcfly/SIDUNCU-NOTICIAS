package com.siduncu_proyect.siduncuapp.Services;
import com.siduncu_proyect.siduncuapp.Models.Usuario;
import java.util.List;

/**
 *
 * @author siduncuNotebook
 */
public interface IUsuarioService {
   public List<Usuario> getUsuarios();
    
    public Usuario saveUsuario(Usuario usuario);
    
    public void deleteUsuario(Long id);
    
    public Usuario findUsuario(Long id);
    
    public void updateUsuario(Usuario usuario);

    public Usuario buscarPorNombreUsuario(String nombreUsuario);

    public boolean verificarPassword(String rawPassword, String encodedPassword);

}
