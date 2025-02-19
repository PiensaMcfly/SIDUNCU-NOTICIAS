package com.siduncu_proyect.siduncuapp.Controllers;

import com.siduncu_proyect.siduncuapp.Models.Categoria;
import com.siduncu_proyect.siduncuapp.Models.Noticia;
import com.siduncu_proyect.siduncuapp.Models.Usuario;
import com.siduncu_proyect.siduncuapp.Services.CategoriaService;
import com.siduncu_proyect.siduncuapp.Services.NoticiaService;
import com.siduncu_proyect.siduncuapp.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@CrossOrigin("http://localhost:3000/")
@RequestMapping("/")

public class HomeController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private NoticiaService noticiaService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public String home(Model model) {
        // Recuperar todos los datos
        List<Usuario> usuarios = usuarioService.getUsuarios();
        List<Noticia> noticias = noticiaService.getNoticia();
        List<Categoria> categorias = categoriaService.getCategoria();

        // Agregar los datos al modelo
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("noticias", noticias);
        model.addAttribute("categorias", categorias);

        // Retornar la vista
        return "index";
    }

    @GetMapping("/formulario")
    public String form(Model model) {
        // Obtener la lista de categorías desde el servicio
        List<Categoria> categorias = categoriaService.getCategoria();
        model.addAttribute("categorias", categorias);
        return "formulario";
    }

    //@GetMapping("/login")
    //public String login() {
      //  return "login";
   // }

    @PostMapping("/login")
    public String iniciarSesion(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                Model model) {
        // Buscar el usuario por su nombre de usuario
        Usuario usuario = usuarioService.buscarPorNombreUsuario(username);

        if (usuario != null && usuarioService.verificarPassword(password, usuario.getPassword())) {
            // Credenciales válidas: Redirige al inicio
            model.addAttribute("usuario", usuario);
            return "redirect:/";
        }

        // Si las credenciales son incorrectas, retorna al login con mensaje de error
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login";
    }


}