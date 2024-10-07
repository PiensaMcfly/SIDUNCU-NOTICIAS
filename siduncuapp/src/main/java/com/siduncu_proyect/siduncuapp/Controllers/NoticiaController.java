/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.siduncu_proyect.siduncuapp.Controllers;

import com.siduncu_proyect.siduncuapp.Models.Noticia;
import com.siduncu_proyect.siduncuapp.Models.Usuario;
import com.siduncu_proyect.siduncuapp.Services.INoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticias")
public class NoticiaController {

    @Autowired
    private INoticiaService servicioNoticia;

    @GetMapping("/lista")
    public List<Noticia> getAll(){ return servicioNoticia.getNoticia();}

  @PostMapping("/crear")
    public ResponseEntity <Noticia> crearNoticia(@RequestBody Noticia noti){
        Noticia noticia = servicioNoticia.saveNoticia(noti);
        return new ResponseEntity<Noticia>(noticia, HttpStatus.OK);
  }

  @GetMapping("/lista/{id}")
    public Noticia getNoticia(@PathVariable Long id){return servicioNoticia.findNoticia(id);}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Noticia> deleteNoticia(@PathVariable Long id){
        Noticia noticia = servicioNoticia.findNoticia(id);
        if(noticia != null){
            servicioNoticia.deleteNoticia(id);
        }else { return new ResponseEntity<Noticia>(noticia,HttpStatus.INTERNAL_SERVER_ERROR);}
        return new ResponseEntity<Noticia>(noticia,HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Noticia> actualizarNoticia(@PathVariable Long id){
        Noticia noticia= servicioNoticia.findNoticia(id);
        if (noticia != null){
            servicioNoticia.updateNoticia(noticia);
        }else {return new ResponseEntity<Noticia>(noticia,HttpStatus.INTERNAL_SERVER_ERROR);}
        return new ResponseEntity<Noticia>(noticia,HttpStatus.OK);
    }

}
