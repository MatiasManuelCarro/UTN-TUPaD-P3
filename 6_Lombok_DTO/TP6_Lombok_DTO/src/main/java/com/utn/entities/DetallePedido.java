package com.utn.entities;

import com.utn.entities.Base;
import com.utn.entities.Producto;
import lombok.*;

import java.util.Objects;

@Getter
@Setter

@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor

public class DetallePedido extends Base {

    private int cantidad;
    private Double subtotal;
    private Producto producto;

    @Builder
    public DetallePedido(int cantidad, Double subtotal) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
}