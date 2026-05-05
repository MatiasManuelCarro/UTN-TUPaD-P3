package com.tup.programacion3.entities;
import java.time.LocalDateTime;

public abstract class Base {

    protected long id;
    protected boolean eliminado;
    protected LocalDateTime createdAt;

    public Base() {
        this.createdAt = LocalDateTime.now();
        this.eliminado = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
