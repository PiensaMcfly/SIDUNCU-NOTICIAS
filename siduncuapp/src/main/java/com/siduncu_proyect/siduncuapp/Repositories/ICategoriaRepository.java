package com.siduncu_proyect.siduncuapp.Repositories;

import com.siduncu_proyect.siduncuapp.Models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository <Categoria,Long> {
}
