package com.utn.entities;

import com.utn .enums.Estado;
import com.utn.enums.FormaPago;
import com.utn.entities.Base;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formapago;
/*    private Usuario usuario; //revisar*/

    //coleccion de detalle pedidos
    @Builder.Default
    private Set<DetallePedido> detallePedidos = new HashSet<>();


    //Agregar detalle
    public void addDetallePedido(int cantidad, Producto producto) {

        //si ya se encuentra en el detalle aumenta la cantidad
        for (DetallePedido d : detallePedidos) {
            if (d.getProducto().equals(producto)) {
                d.setCantidad(d.getCantidad() + cantidad);
                d.setSubtotal(d.getCantidad() * producto.getPrecio());
                return;
            }
        }

        double subtotal = cantidad * producto.getPrecio();
        DetallePedido detalle = new DetallePedido(cantidad, subtotal);
        detalle.setProducto(producto);
        detallePedidos.add(detalle);
    }

    //Buscar detalle por producto
    public DetallePedido findDetallePedidoByProducto(Producto producto) {
        for (DetallePedido det : detallePedidos) {
            if (det.getProducto().equals(producto)) {
                return det;
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