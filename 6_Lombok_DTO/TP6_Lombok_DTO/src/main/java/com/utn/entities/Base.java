package com.utn.entities;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;


@Getter
@ToString
@EqualsAndHashCode(of={"id"})

public abstract class Base {


    protected final long id;
    protected static int idCounter = 0; //contador de IDs
    protected boolean eliminado;
    protected LocalDateTime createdAt;


    public Base() {
        this.createdAt = LocalDateTime.now();
        this.eliminado = false;
        this.id = ++idCounter; //aumenta el numero de ID
    }

}