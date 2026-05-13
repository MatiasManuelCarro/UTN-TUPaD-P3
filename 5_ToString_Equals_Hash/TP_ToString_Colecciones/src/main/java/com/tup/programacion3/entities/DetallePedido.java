package com.tup.programacion3.entities;


import java.util.Objects;

public class DetallePedido extends Base {

    private int cantidad;
    private Double subtotal;
    private Producto producto;

    public DetallePedido() {
        super();
    }

        public DetallePedido(int cantidad, Double subtotal, Producto producto) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }



    @Override
    public String toString() {
        return "DetallePedido{" +
                "producto=" + producto.getNombre() +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DetallePedido detallePedido = (DetallePedido) obj;
        return this.id == detallePedido.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}





