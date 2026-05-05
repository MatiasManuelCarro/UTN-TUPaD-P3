package com.tup.programacion3.entities;
import com.tup.programacion3.enums.Estado;
import com.tup.programacion3.enums.FormaPago;

import java.time.LocalDate;
import java.util.Objects;

public class Pedido extends Base {
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formapago;
    private Usuario usuario;


    //constructor sin usuario
    public Pedido(LocalDate fecha, Estado estado, Double total, FormaPago formapago) {
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.formapago = formapago;
    }

    public Pedido() {
    }

    public Pedido(LocalDate fecha, Estado estado, Double total, FormaPago formapago, Usuario usuario) {
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.formapago = formapago;
        this.usuario = usuario;
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



