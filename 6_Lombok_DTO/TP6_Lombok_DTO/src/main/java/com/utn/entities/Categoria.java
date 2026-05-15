package com.utn.entities;

import com.utn.entities.Base;
import com.utn.entities.Producto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true, exclude = "productos")
@EqualsAndHashCode(callSuper = false, of = {"nombre"})
@AllArgsConstructor
@NoArgsConstructor
public class Categoria extends Base {

    private String nombre;
    private String descripcion;

    @Builder.Default
    private Set<Producto> productos = new HashSet<>();


}

