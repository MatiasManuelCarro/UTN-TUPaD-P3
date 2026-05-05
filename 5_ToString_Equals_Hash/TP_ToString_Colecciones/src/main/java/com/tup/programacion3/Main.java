package com.tup.programacion3;

import com.tup.programacion3.entities.Pedido;
import com.tup.programacion3.entities.Usuario;
import com.tup.programacion3.enums.Estado;
import com.tup.programacion3.enums.FormaPago;
import com.tup.programacion3.enums.Rol;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        Usuario u = new Usuario("Juan", "Perez", "jp@mail.com", "123", "pass", Rol.ADMIN);

        Pedido p1 = new Pedido(LocalDate.now(), Estado.PENDIENTE, 1500.0, FormaPago.EFECTIVO);
        Pedido p2 = new Pedido(LocalDate.now(), Estado.PENDIENTE, 2000.0, FormaPago.TARJETA);

        u.addPedido(p1);
        u.addPedido(p2);

        System.out.println(p1.getUsuario().getNombre()); // Juan
        System.out.println(u.getPedidos().size());       // 2

    }
}
