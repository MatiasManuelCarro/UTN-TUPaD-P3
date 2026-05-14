package com.utn.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false , of = {"nombre", "precio"})
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Producto extends Base {
    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private boolean disponible;

    private Categoria categoria;

}