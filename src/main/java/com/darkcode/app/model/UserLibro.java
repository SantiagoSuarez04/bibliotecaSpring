package com.darkcode.app.model;

public class UserLibro {
    private String titulo;
    private String autor;
    private String genero;
    private String fecha_publicacion;
    private String isbn;
    private String cantidad_disponible;
    private String descripcion;
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
    public String getFecha_publicacion() {
        return fecha_publicacion;
    }
    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getCantidad_disponible() {
        return cantidad_disponible;
    }
    public void setCantidad_disponible(String cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        return "UserLibro [titulo=" + titulo + ", autor=" + autor + ", genero=" + genero + ", fecha_publicacion="
                + fecha_publicacion + ", isbn=" + isbn + ", cantidad_disponible=" + cantidad_disponible
                + ", descripcion=" + descripcion + "]";
    }
    
}
