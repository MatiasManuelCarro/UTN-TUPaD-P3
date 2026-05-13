package com.tup.programacion3.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Categoria extends Base{
    private String nombre;
    private String descripcion;

    private Set<Producto> productos = new HashSet<>();

    public Categoria() {
    }

    public Categoria(String nombre, String descripcion) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void addProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", productos=" + productos.size() +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Categoria categoria = (Categoria) obj;
        return this.id == categoria.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


