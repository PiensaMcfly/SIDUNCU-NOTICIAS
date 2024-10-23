/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.siduncu_proyect.siduncuapp.Services;

import com.siduncu_proyect.siduncuapp.Models.Imagen;
import java.util.List;

/**
 *
 * @author siduncuNotebook
 */
public interface IImagenService {

    public List<Imagen> getImagen();

    public Imagen saveImagen(Imagen imagen);

    public void deleteImagen(Long id);

    public Imagen findImagen(Long id);

    public void updateImagen(Imagen imagen);
}
