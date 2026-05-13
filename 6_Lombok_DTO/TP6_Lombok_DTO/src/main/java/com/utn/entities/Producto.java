package com.utn.entities;

import com.utn.entities.Base;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter

@ToString
//revisar el callsuper
@EqualsAndHashCode(callSuper = false, of = {"nombre", "precio"})

public class Producto extends Base {
    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private boolean disponible;

    private Categoria categoria;

    public Producto() {
        super();
    }

    public Producto(String nombre, Double precio, String descripcion, int stock, String imagen, boolean disponible) {
        super();
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.disponible = disponible;
    }


}