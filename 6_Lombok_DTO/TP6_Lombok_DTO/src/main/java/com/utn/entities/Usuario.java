package com.utn.entities;
import com.utn.enums.Rol;
import com.utn.entities.Base;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, of = {"mail"})


public class Usuario extends Base {
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contraseña;
    private Rol rol;

//    private List<Pedido> pedidos = new ArrayList<>();


    public Usuario() {
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



}