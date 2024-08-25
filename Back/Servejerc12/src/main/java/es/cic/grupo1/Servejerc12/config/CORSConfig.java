package es.cic.grupo1.Servejerc12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/coches") // Permitir solo la ruta /coches
                        .allowedOrigins("http://localhost:5173", "http://localhost:4173") // Permitir estos orígenes
                        .allowedMethods("GET", "POST") // Permitir solo estos métodos HTTP
                        .allowedHeaders("Content-Type", "Authorization"); // Permitir solo estos encabezados
            }
        };
    }
}