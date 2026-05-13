package com.utn.entities;

import com.utn.entities.Base;
import com.utn.entities.Producto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter

@ToString
@EqualsAndHashCode(callSuper = true)

public class Categoria extends Base {
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

}
