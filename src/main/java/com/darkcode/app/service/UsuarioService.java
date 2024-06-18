package com.darkcode.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darkcode.app.domain.Usuario;
import com.darkcode.app.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        // Implementar lógica para registrar un nuevo usuario en el repositorio
        return usuarioRepository.save(usuario);
    }

    public Usuario editarPerfil(Long id, Usuario usuario) {
        // Implementar lógica para editar el perfil de un usuario existente
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setEmail(usuario.getEmail());
            // Agregar más campos según sea necesario
            return usuarioRepository.save(usuarioExistente);
        }
        return null;
    }

    public Iterable<Usuario> listarUsuarios() {
        // Implementar lógica para obtener todos los usuarios del repositorio
        return usuarioRepository.findAll();
    }
}
