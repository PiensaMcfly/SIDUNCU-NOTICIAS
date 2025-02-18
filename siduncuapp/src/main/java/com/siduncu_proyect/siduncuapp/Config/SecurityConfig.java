import com.siduncu_proyect.siduncuapp.Services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder; // Solo para desarrollo
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**").permitAll() // Rutas públicas
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Solo usuarios con rol ADMIN
                        .anyRequest().authenticated() // Rutas que requieren autenticación
                )
                .formLogin((form) -> form
                        .loginPage("/login") // Ruta al formulario de inicio de sesión
                        .usernameParameter("nombreUsuario")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true) // Redirigir tras login exitoso
                        .permitAll() // No requiere autenticación para acceder a la página de login
                )
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Ruta de logout
                        .logoutSuccessUrl("/") // Redirigir tras logout
                        .permitAll());
        http.csrf().disable();


        return http.build();
    }

    @Bean
    public AuthenticationManagerBuilder authManagerBuilder(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance()); // Solo para desarrollo
        return auth;
    }

}