package com.tup.programacion3.entities;
import java.time.LocalDate;

public class Pedido {
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formapago;


    public Pedido() {
    }

    public Pedido(LocalDate fecha, Estado estado, Double total, FormaPago formapago) {
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.formapago = formapago;
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

}



