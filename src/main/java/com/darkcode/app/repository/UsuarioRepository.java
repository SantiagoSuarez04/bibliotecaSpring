package com.darkcode.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.darkcode.app.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
   
}

