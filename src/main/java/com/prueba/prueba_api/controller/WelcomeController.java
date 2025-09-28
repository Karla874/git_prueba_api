package com.prueba.prueba_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeController {
    
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> welcome() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Bienvenido a la API de Gestión de Usuarios");
        response.put("version", "1.0.0");
        response.put("status", "activa");
        
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("GET /users", "Obtener lista de usuarios registrados");
        endpoints.put("POST /users", "Registrar un nuevo usuario");
        
        response.put("endpoints", endpoints);
        
        Map<String, String> ejemplo = new HashMap<>();
        ejemplo.put("registrar", "curl -X POST http://localhost:8080/users -H 'Content-Type: application/json' -d '{\"id\": 1, \"name\": \"Juan\", \"email\": \"juan@example.com\"}'");
        ejemplo.put("consultar", "curl -X GET http://localhost:8080/users");
        
        response.put("ejemplos", ejemplo);
        
        return ResponseEntity.ok(response);
    }
}