package com.utn.entities;

import com.utn .enums.Estado;
import com.utn.enums.FormaPago;
import com.utn.entities.Base;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)

public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formapago;
    private Usuario usuario;

    //coleccion de detalle pedidos
    private Set<DetallePedido> detallePedidos = new HashSet<>();

    public Pedido() {
        super();
    }

    public Pedido(LocalDate fecha, Estado estado, Double total, FormaPago formapago) {
        super();
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.formapago = formapago;
    }

    //Agregar detalle
    public void addDetallePedido(int cantidad, Producto producto) {
        double subtotal = cantidad * producto.getPrecio();
        DetallePedido detalle = new DetallePedido(cantidad, subtotal);
        detalle.setProducto(producto);
        detallePedidos.add(detalle);
    }

    //Buscar detalle por producto
    public DetallePedido findDetallePedidoByProducto(Producto producto) {
        for (DetallePedido d : detallePedidos) {
            if (d.getProducto().equals(producto)) {
                return d;
            }
        }
        return null;
    }


    //Eliminar detalle por producto
    public void deleteDetalleByProducto(Producto producto) {
        detallePedidos.removeIf(d -> d.getProducto().equals(producto));
    }

    @Override
    public void calcularTotal() {
        double totalFinal = 0.0;

        for (DetallePedido d : detallePedidos) {
            totalFinal += d.getSubtotal();
        }

        this.total = totalFinal;

        System.out.println("Total del pedido: " + totalFinal);
    }


}