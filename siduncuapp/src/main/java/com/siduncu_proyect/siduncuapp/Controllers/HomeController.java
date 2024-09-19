package com.siduncu_proyect.siduncuapp.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author siduncuNotebook
 */

@Controller
//@CrossOrigin("http://localhost:3000/")
@RequestMapping("/")

public class HomeController {
    
    @GetMapping("/")
    public String home(){
    return "index.html";
    }
    
}
