package com.tup.programacion3.entities;
import com.tup.programacion3.enums.Estado;
import com.tup.programacion3.enums.FormaPago;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido extends Base {
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formapago;
    private Usuario usuario;


    private List<DetallePedido> detallePedidos = new ArrayList<>();

    public Pedido() {
        super();
    }


    //constructor sin usuario
    public Pedido(LocalDate fecha, Estado estado, Double total, FormaPago formapago) {
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.formapago = formapago;
    }



    public Pedido(LocalDate fecha, Estado estado, Double total, FormaPago formapago, Usuario usuario) {
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.formapago = formapago;
        this.usuario = usuario;
    }


    // 1) Agregar detalle
    public void addDetallePedido(int cantidad, Producto producto) {
        double subtotal = cantidad * producto.getPrecio();
        DetallePedido detalle = new DetallePedido(cantidad, subtotal);
        detallePedidos.add(detalle);
    }

    // 2) Buscar detalle por producto
    public DetallePedido findDetallePedidoByProducto(Producto producto) {
        for (DetallePedido d : detallePedidos) {
            if (d.getSubtotal() == producto.getPrecio() * d.getCantidad()) {
                return d;
            }
        }
        return null;
    }

    // 3) Eliminar detalle por producto
    public void deleteDetalleByProducto(Producto producto) {
        detallePedidos.removeIf(
                d -> d.getSubtotal() == producto.getPrecio() * d.getCantidad()
        );
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
    public String toString() {
        return "Pedido{" +
                "fecha=" + fecha +
                ", estado=" + estado +
                ", total=" + total +
                ", formapago=" + formapago +
                ", id=" + id +
                ", eliminado=" + eliminado +
                ", createdAt=" + createdAt +
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



