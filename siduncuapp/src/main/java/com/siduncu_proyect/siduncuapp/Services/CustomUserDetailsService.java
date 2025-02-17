package com.siduncu_proyect.siduncuapp.Services;

import com.siduncu_proyect.siduncuapp.Models.Usuario;
import com.siduncu_proyect.siduncuapp.Repositories.IusuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    IusuarioRepository _usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Aquí podrías agregar lógica para buscar el usuario en tu base de datos.
        Usuario user =_usuarioRepo.buscarPorUsuario(username);
        //

        if (user != null) {

            List<GrantedAuthority> permisos = new ArrayList(); // Lista de permiso/roles para el usuario
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + user.getRol().toString()); // Asignación del rol
            permisos.add(p);

            return new User(user.getNombreUsuario(), user.getPassword(), permisos); // Devuelve un UserDetails con los datos
        } else {
            // Manejo de error si el usuario no existe (incompleto en el fragmento)
        }

        throw new UsernameNotFoundException("Usuario no encontrado: " + username);
    }

}


