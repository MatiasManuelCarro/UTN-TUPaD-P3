package com.utn.entities;

import com.utn.entities.Base;
import com.utn.entities.Producto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter

@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Categoria extends Base {

    private String nombre;
    private String descripcion;

    @Builder.ObtainVia(method = "")
    private Set<Producto> productos = new HashSet<>();
}
}
