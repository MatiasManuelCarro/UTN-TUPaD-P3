package com.tup.programacion3.entities;
import java.time.LocalDateTime;
import java.util.Objects;

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

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", eliminado=" + eliminado +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return id == base.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
