package com.siduncu_proyect.siduncuapp;

import com.siduncu_proyect.siduncuapp.Config.PasswordConfig;
import com.siduncu_proyect.siduncuapp.Models.Usuario;
import com.siduncu_proyect.siduncuapp.Services.UsuarioService;
import com.siduncu_proyect.siduncuapp.Utils.PasswordGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SiduncuappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiduncuappApplication.class, args);
	}
    PasswordEncoder passwordGenerator = new PasswordConfig().passwordEncoder();
	UsuarioService servicioUsuario = new UsuarioService();
	Usuario admin = new Usuario();
	public void init(){
		String pass = "admin";
		admin.setPassword(pass.toLowerCase());
		admin.setNombreUsuario("admin");
		admin.setEmail("<EMAIL>");
    	admin.setPassword(passwordGenerator.encode(admin.getPassword()));
		servicioUsuario.saveUsuario(admin);
	}
}
