package com.siduncu_proyect.siduncuapp.Repositories;

import com.siduncu_proyect.siduncuapp.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IusuarioRepository extends JpaRepository <Usuario,Long> {


    @Query("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario")
    public Usuario FindByNombreUsuario(@Param("nombreUsuario")String nombreUsuario);
}
