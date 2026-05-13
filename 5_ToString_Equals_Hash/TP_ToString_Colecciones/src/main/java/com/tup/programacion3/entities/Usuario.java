package com.tup.programacion3.entities;
import com.tup.programacion3.enums.Rol;

import java.util.*;


public class Usuario extends Base{
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contraseña;
    private Rol rol;

//    private List<Pedido> pedidos = new ArrayList<>();


    public Usuario(){
        super();
    }

    public Usuario(String nombre, String apellido, String mail, String celular, String contraseña, Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.celular = celular;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    //sets de pedidos
    private Set<Pedido> pedidos = new HashSet<>();

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", mail='" + mail + '\'' +
                ", celular='" + celular + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", rol=" + rol + '\'' +
                ", id=" + id + '\'' +
                ", eliminado=" + eliminado + '\'' +
                ", createdAt=" + createdAt + '\'' +
                "{Base = " + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(mail, usuario.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mail);
    }
}

