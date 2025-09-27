package com.prueba.prueba_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.prueba.prueba_api.model.Usuario;
import com.prueba.prueba_api.service.UserService;
import java.util.*;

//REST
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

	//POST
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        try {
            userService.registrarUsuario(usuario);
            return ResponseEntity.ok(Map.of("message", "Usuario registrado exitosamente."));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    //GET
    @GetMapping
    public List<Usuario> obtenerTodosUsuarios() {
        return userService.obtenerUsuarios();
    }
}