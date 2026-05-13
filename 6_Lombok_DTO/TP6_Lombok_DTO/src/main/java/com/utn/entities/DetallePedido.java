package com.utn.entities;

import com.utn.entities.Base;
import com.utn.entities.Producto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter

@ToString
@EqualsAndHashCode(callSuper = true)

public class DetallePedido extends Base {

    private int cantidad;
    private Double subtotal;
    private Producto producto;

    public DetallePedido() {
        super();
    }

    public DetallePedido(int cantidad, Double subtotal) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
}