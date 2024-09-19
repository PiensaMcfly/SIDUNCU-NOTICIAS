package com.siduncu_proyect.siduncuapp.Controllers;
import com.siduncu_proyect.siduncuapp.Models.Usuario;
import com.siduncu_proyect.siduncuapp.Services.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author siduncuNotebook
 */

@Controller
@RequestMapping("/usuarios")
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
}
