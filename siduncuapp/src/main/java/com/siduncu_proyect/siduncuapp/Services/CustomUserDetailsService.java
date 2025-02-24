package com.siduncu_proyect.siduncuapp.Services;

import com.siduncu_proyect.siduncuapp.Enums.Rol;
import com.siduncu_proyect.siduncuapp.Models.Usuario;
import com.siduncu_proyect.siduncuapp.Repositories.IusuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Collections;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    IusuarioRepository _usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario user = _usuarioRepo.FindByNombreUsuario(nombreUsuario);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con nombre: " + nombreUsuario);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getNombreUsuario(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRol())
        );
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Rol rol) {
        return Collections.singletonList(new SimpleGrantedAuthority(rol.name()));
    }
}


