package com.darkcode.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darkcode.app.domain.Biblioteca;
import com.darkcode.app.domain.Usuario;
import com.darkcode.app.repository.BibliotecaRepository;
import com.darkcode.app.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
     @Autowired
    BibliotecaRepository bibliotecaRepository;
    // Endpoint para registrar un nuevo usuario
    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
            return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para editar el perfil de un usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarPerfil(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        try {
            Usuario usuarioActualizado = usuarioService.editarPerfil(id, usuario);
            if (usuarioActualizado != null) {
                return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para añadir préstamo de libro (redireccionar a listar libros)
     @GetMapping("/librosPrestamo")
    public ResponseEntity<List<Biblioteca>> getAllLibros(@RequestParam(required = false)String nombre){
        try {
            List<Biblioteca> bibliotecas = new ArrayList<>();
            if(nombre == null)
                bibliotecas.addAll(bibliotecaRepository.findAll());
            else
                bibliotecas.addAll(bibliotecaRepository.findByNombreContaining(nombre));

            return new ResponseEntity<>(bibliotecas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para obtener todos los usuarios (solo para propósitos de administración)
    @GetMapping("")
    public ResponseEntity<Iterable<Usuario>> listarUsuarios() {
        try {
            Iterable<Usuario> usuarios = usuarioService.listarUsuarios();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

