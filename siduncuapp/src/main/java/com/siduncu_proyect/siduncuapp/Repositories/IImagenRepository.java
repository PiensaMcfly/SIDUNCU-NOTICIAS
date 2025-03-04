/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.siduncu_proyect.siduncuapp.Repositories;

import com.siduncu_proyect.siduncuapp.Models.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author siduncuNotebook
 */
@Repository
public interface IImagenRepository extends JpaRepository<Imagen, Long>{
    
}
