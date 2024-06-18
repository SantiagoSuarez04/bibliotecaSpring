package com.darkcode.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darkcode.app.domain.Biblioteca
;
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
    List<Biblioteca> findByNombreContaining(String nombre);
    List<Biblioteca> findByAutorContaining(String autor);
    List<Biblioteca> findByGeneroContaining(String genero);
    List<Biblioteca> findByFechaPublicacionContaining(String fechaPublicacion);

}
