package com.utn.entities;

import com.utn.entities.Base;
import com.utn.entities.Producto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Getter
@Setter

@ToString
@EqualsAndHashCode(callSuper = false, of = {"producto"})
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DetallePedido extends Base {

    private int cantidad;
    private Double subtotal;
    private Producto producto;

    public DetallePedido(int cantidad, Double subtotal) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;

    }
}