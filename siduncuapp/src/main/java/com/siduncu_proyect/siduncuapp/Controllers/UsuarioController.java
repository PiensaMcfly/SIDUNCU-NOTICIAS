package com.siduncu_proyect.siduncuapp.Controllers;
import com.siduncu_proyect.siduncuapp.Models.Usuario;
import com.siduncu_proyect.siduncuapp.Services.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService servicioUsuario;
    
    @GetMapping("/lista")
    public List<Usuario> getAll(){
    return servicioUsuario.getUsuarios();
    }
    
    @PostMapping("/crear")
    public ResponseEntity <Usuario> crearUsuario(@RequestBody Usuario user){
        Usuario usuario = servicioUsuario.saveUsuario(user);
        return new ResponseEntity<Usuario> (usuario, HttpStatus.OK);
    }
    
    @GetMapping("/lista/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        return servicioUsuario.findUsuario(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Usuario> deleteUsuario(@PathVariable Long id){
        Usuario user = servicioUsuario.findUsuario(id);
        if (user != null){
            servicioUsuario.deleteUsuario(id);
        } else {
            return new ResponseEntity<Usuario> (user, HttpStatus.INTERNAL_SERVER_ERROR);
        }
     return new ResponseEntity <Usuario> (user, HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity <Usuario> actualizarUsuario(@PathVariable Long id) {
    Usuario user = servicioUsuario.findUsuario(id);
    if (user != null){
        servicioUsuario.updateUsuario(user);
    } else {
    return new ResponseEntity<Usuario> (user, HttpStatus.INTERNAL_SERVER_ERROR);
    }  
    return new ResponseEntity <Usuario> (user, HttpStatus.OK);
    }
}
