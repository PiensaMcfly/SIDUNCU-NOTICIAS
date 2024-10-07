package com.siduncu_proyect.siduncuapp.Controllers;

import com.siduncu_proyect.siduncuapp.Models.Categoria;
import com.siduncu_proyect.siduncuapp.Services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private ICategoriaService servicioCategoria;

    @GetMapping("/lista")
    public List<Categoria> getAll(){ return servicioCategoria.getCategoria();}

    @PostMapping("/crear")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria){
        Categoria Categoria = servicioCategoria.saveCategoria(categoria);
        return new ResponseEntity<Categoria>(Categoria, HttpStatus.OK);
    }

    @GetMapping("/lista/{id}")
    public Categoria getCategoria(@PathVariable Long id){return servicioCategoria.findCategoria(id);}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Categoria> deleteCategoria(@PathVariable Long id){
        Categoria Categoria = servicioCategoria.findCategoria(id);
        if(Categoria != null){
            servicioCategoria.deleteCategoria(id);
        }else { return new ResponseEntity<Categoria>(Categoria,HttpStatus.INTERNAL_SERVER_ERROR);}
        return new ResponseEntity<Categoria>(Categoria,HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id){
        Categoria Categoria= servicioCategoria.findCategoria(id);
        if (Categoria != null){
            servicioCategoria.updateCategoria(Categoria);
        }else {return new ResponseEntity<Categoria>(Categoria,HttpStatus.INTERNAL_SERVER_ERROR);}
        return new ResponseEntity<Categoria>(Categoria,HttpStatus.OK);
    }
}
