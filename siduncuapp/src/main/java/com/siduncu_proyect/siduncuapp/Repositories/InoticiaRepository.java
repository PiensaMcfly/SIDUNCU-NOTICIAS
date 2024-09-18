package com.siduncu_proyect.siduncuapp.Repositories;

import com.siduncu_proyect.siduncuapp.Models.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InoticiaRepository extends JpaRepository <Noticia,Long> {

}
