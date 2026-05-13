package com.tup.programacion3.entities;

import com.tup.programacion3.enums.Estado;
import com.tup.programacion3.enums.FormaPago;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pedido extends Base implements Calculable{
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
        DetallePedido detalle = new DetallePedido(cantidad, subtotal, producto);
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





    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public FormaPago getFormapago() {
        return formapago;
    }

    public void setFormapago(FormaPago formapago) {
        this.formapago = formapago;
    }

//    Detalles de pedido

    @Override
    public void calcularTotal() {
        double totalFinal = 0.0;

        for (DetallePedido d : detallePedidos) {
            totalFinal += d.getSubtotal();
        }

        this.total = totalFinal;

        System.out.println("Total del pedido: " + totalFinal);
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "fecha=" + fecha +
                ", estado=" + estado +
                ", total=" + total +
                ", formaPago=" + formapago +
                ", detalles=" + detallePedidos.size() +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pedido pedido = (Pedido) obj;
        return this.id == pedido.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}



