package com.tup.programacion3.entities;
import java.time.LocalDateTime;

public abstract class Base {


    protected final long id;
    protected static int idCounter = 0; //contador de IDs
    protected boolean eliminado;
    protected LocalDateTime createdAt;

    public Base() {
        this.createdAt = LocalDateTime.now();
        this.eliminado = false;
        this.id=++idCounter; //aumenta el numero de ID
    }

    public long getId() {
        return id;
    }

/*
    public void setId(long id) {
        this.id = id;
    }
*/

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
