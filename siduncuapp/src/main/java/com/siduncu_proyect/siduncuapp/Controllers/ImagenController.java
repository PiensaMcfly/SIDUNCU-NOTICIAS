/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.siduncu_proyect.siduncuapp.Controllers;

import com.siduncu_proyect.siduncuapp.Models.Imagen;
import com.siduncu_proyect.siduncuapp.Repositories.IImagenRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author siduncuNotebook
 */
@RestController
@RequestMapping("/imagenes")
@CrossOrigin(origins = "http://localhost:3000")
public class ImagenController {
    @Autowired
    IImagenRepository imagenRepository;
   
}
