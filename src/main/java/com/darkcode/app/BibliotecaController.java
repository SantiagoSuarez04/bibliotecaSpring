package com.darkcode.app;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darkcode.app.domain.Biblioteca;
import com.darkcode.app.repository.BibliotecaRepository;

import ch.qos.logback.core.model.Model;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BibliotecaController {
    
    @Autowired
    BibliotecaRepository bibliotecaRepository;

    @GetMapping("/libros")
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
    
     @GetMapping("/libros/{id}")
    public ResponseEntity<Biblioteca> getLibroById(@PathVariable("id") long id){
        Optional<Biblioteca> bibliotecaData = bibliotecaRepository.findById(id);
        
        if (bibliotecaData.isPresent()) {
            return new ResponseEntity<>(bibliotecaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/librosNombre/{nombre}")
    public ResponseEntity<List<Biblioteca>> getLibrosByNombre(@PathVariable String nombre) {
        try {
            List<Biblioteca> bibliotecas = bibliotecaRepository.findByNombreContaining(nombre);
            return new ResponseEntity<>(bibliotecas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/librosAutor/{autor}")
    public ResponseEntity<List<Biblioteca>> getLibrosByAutor(@PathVariable String autor) {
        try {
            List<Biblioteca> bibliotecas = bibliotecaRepository.findByAutorContaining(autor);
            return new ResponseEntity<>(bibliotecas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/librosGenero/{genero}")
    public ResponseEntity<List<Biblioteca>> getLibrosByGenero(@PathVariable String genero) {
        try {
            List<Biblioteca> bibliotecas = bibliotecaRepository.findByGeneroContaining(genero);
            return new ResponseEntity<>(bibliotecas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/librosFecha/{fecha}")
    public ResponseEntity<List<Biblioteca>> getLibrosByFecha(@PathVariable String fecha) {
        try {
            List<Biblioteca> bibliotecas = bibliotecaRepository.findByFechaPublicacionContaining(fecha);
            return new ResponseEntity<>(bibliotecas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
     @PostMapping("/libros")
public ResponseEntity<Biblioteca> createLibro(@RequestBody Biblioteca biblioteca){
    try{
        Biblioteca _biblioteca= bibliotecaRepository
              .save(new Biblioteca(biblioteca.getNombre(), biblioteca.getAutor(), biblioteca.getGenero(), biblioteca.getFechaPublicacion()));
        return new ResponseEntity<>(_biblioteca, HttpStatus.CREATED);
    } catch (Exception e){
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
    @PutMapping("libros/{id}")
    public ResponseEntity<Biblioteca> updateLibros(@PathVariable("id")long id, @RequestBody Biblioteca biblioteca){
        Optional<Biblioteca> bibliotecaData = bibliotecaRepository.findById(id);

        if(bibliotecaData.isPresent()){
            Biblioteca _biblioteca =bibliotecaData.get();
            _biblioteca.setNombre(biblioteca.getNombre());
            _biblioteca.setAutor(biblioteca.getAutor());
            _biblioteca.setGenero(biblioteca.getGenero());
            _biblioteca.setFechaPublicacion(biblioteca.getFechaPublicacion());
            return new ResponseEntity<>(bibliotecaRepository.save(_biblioteca), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/libros/{id}")
public ResponseEntity<HttpStatus> deleteLibro(@PathVariable("id") long id){
    try {
        bibliotecaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@DeleteMapping("/libros")
public ResponseEntity<HttpStatus> deleteAllLibros(){
    try{
        bibliotecaRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }catch (Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
@GetMapping("/guardar-libro")
    public String mostrarFormularioLibro() {
        return "templates/Libro"; // Nombre del archivo HTML sin extensión ni ruta completa
    }
    @GetMapping("/guardar-libro")
    public String guardarlibro(Model model){
        Biblioteca biblioteca = new Biblioteca();
        model.addAttribute("tutorialAttributes", tutorial);
        return "show_tutorial";

    }

}


