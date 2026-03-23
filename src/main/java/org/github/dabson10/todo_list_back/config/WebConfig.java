//package org.github.dabson10.todo_list_back.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig {
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addMapping("/**") // Habilita CORS para todas las rutas
//                .allowedOrigins("http://127.0.0.1:5500") // Tu Front
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
//                .allowedHeaders("*"); // Permite todos los headers (como Content-Type)
//        };
//    }
//}