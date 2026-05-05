package com.tup.programacion3.entities;
import java.time.LocalDateTime;

public abstract class Base {

    protected long id;
    protected boolean eliminado;
    protected LocalDateTime createdAt;
}
