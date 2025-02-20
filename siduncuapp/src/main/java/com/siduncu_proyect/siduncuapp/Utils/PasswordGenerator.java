package com.siduncu_proyect.siduncuapp.Utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin"; // Cambia la contraseña aquí
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Contraseña codificada: " + encodedPassword);
        // Finaliza la ejecución
        SpringApplication.exit(SpringApplication.run(PasswordGenerator.class, args));
    }
}