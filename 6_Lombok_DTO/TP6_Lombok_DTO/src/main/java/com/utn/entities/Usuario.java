package com.utn.entities;
import com.utn.enums.Rol;
import com.utn.entities.Base;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.*;

@Getter
@Setter

@ToString(callSuper = true, exclude = "contrasenia")
@EqualsAndHashCode(callSuper = false, of = {"mail"})

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends Base {
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contrasenia;
    private Rol rol;

    //sets de pedidos
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();
    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }



}