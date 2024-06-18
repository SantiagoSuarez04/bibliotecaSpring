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
        return usuarioRepository.save(usuario);
    }

    public Usuario editarPerfil(Long id, Usuario usuario) {
        
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setEmail(usuario.getEmail());
           
            return usuarioRepository.save(usuarioExistente);
        }
        return null;
    }

    public Iterable<Usuario> listarUsuarios() {
       
        return usuarioRepository.findAll();
    }
}
