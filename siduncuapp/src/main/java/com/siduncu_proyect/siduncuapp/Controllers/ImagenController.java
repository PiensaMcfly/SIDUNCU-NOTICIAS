/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.siduncu_proyect.siduncuapp.Controllers;

import com.siduncu_proyect.siduncuapp.Models.Imagen;
import com.siduncu_proyect.siduncuapp.Repositories.IImagenRepository;
import com.siduncu_proyect.siduncuapp.Services.ImagenService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    ImagenService imagenService;
    
    @GetMapping("/lista")
    public List<Imagen> getAll(){
        return imagenService.getImagen();
    }
    
    @GetMapping("/lista/{id}")
    public Imagen getOneImagen(Long id){
        return imagenService.findImagen(id);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Imagen> guardarImagen(@RequestBody Imagen img){
        Imagen imagen = imagenService.saveImagen(img);
        return new ResponseEntity<Imagen> (imagen, HttpStatus.OK);
    } 
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Imagen> deleteImagen(@PathVariable Long id) {
        Imagen imagen = imagenService.findImagen(id);
        if (imagen != null) {
            imagenService.deleteImagen(id);
        } else {
            return new ResponseEntity<Imagen>(imagen, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Imagen>(imagen, HttpStatus.OK);
    }
    
   
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Imagen> actualizarNoticia(@PathVariable Long id, @RequestBody Imagen imgActualizada) {
        // Buscar la noticia existente por el ID
        Imagen imagen = imagenService.findImagen(id);

        if (imagen != null) {
            // Actualizar solo los campos que llegan en la solicitud, manteniendo los demás
            imagen.setUrl(imgActualizada.getUrl() != null ? imgActualizada.getUrl() : imagen.getUrl());
        
            imagenService.updateImagen(imagen);

            return new ResponseEntity<>(imagen, HttpStatus.OK);
        } else {
           
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
