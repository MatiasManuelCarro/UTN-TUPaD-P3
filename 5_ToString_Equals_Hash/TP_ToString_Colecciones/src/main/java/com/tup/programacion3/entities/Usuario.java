package com.tup.programacion3.entities;
import com.tup.programacion3.enums.Rol;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Usuario extends Base{
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contraseña;
    private Rol rol;

//    private List<Pedido> pedidos = new ArrayList<>();


    public Usuario(){
    }

    public Usuario(String nombre, String apellido, String mail, String celular, String contraseña, Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.celular = celular;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    private List<Pedido> pedidos = new ArrayList<>();

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
        pedido.setUsuario(this); // relacion
    }

    public List<Pedido> getPedidos() {
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

/*    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void addPedidos(Pedido pedido) {
        this.pedidos.add(pedido);
    }*/

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", mail='" + mail + '\'' +
                ", celular='" + celular + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", rol=" + rol +
                ", id=" + id +
                ", eliminado=" + eliminado +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass()!=obj.getClass())return false;
        Usuario usuario = (Usuario) obj;
        return this.id == usuario.getId() && this.mail.equals(usuario.mail);
            }
    @Override
    public int hashCode(){
        return Objects.hash(id, mail);
    }
}

