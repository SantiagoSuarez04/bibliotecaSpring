package com.darkcode.app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bibliotecas")
public class Biblioteca {
   
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name= "autor")
    private String autor;

    @Column(name= "genero")
    private String genero;

    @Column(name= "fechaPublicacion")
    private String fechaPublicacion;

    public Biblioteca(){

    }
    

    public Biblioteca(String nombre, String autor, String genero, String fechaPublicacion ){
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.fechaPublicacion = fechaPublicacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Biblioteca [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", genero=" + genero
                + ", fechaPublicacion=" + fechaPublicacion + "]";
    }
    

    
}
