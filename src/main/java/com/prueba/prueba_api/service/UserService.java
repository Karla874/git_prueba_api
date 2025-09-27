package com.prueba.prueba_api.service;

import org.springframework.stereotype.Service;
import com.prueba.prueba_api.model.Usuario;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
	//Temporal
	private Map<Long, Usuario> usuarios = new HashMap<>();

    //Registrar
    public Usuario registrarUsuario(Usuario usuario) {
		for (Usuario u : usuarios.values()) {
			if (u.getEmail().equals(usuario.getEmail())) {
            	throw new IllegalArgumentException("El email ya está registrado.");
        		}
		}
		usuarios.put(usuario.getId(), usuario);
		return usuario;
    	}

    	//Obtener
    	public List<Usuario> obtenerUsuarios() {
		return new ArrayList<>(usuarios.values());
	}
}