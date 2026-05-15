package com.utn.entities;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;


@Getter
@ToString
@EqualsAndHashCode(of = {"id"})
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Base {

    //HACER FIJA LA ID INGRESADA EN EL CONSTRUCTOR. QUITAR CONTADOR
    protected static long idCounter = 0; //inicia contador de Ids
    @Builder.Default
    protected long id = ++idCounter;
    @Builder.Default
    protected boolean eliminado = false;
    @Builder.Default
    protected LocalDateTime createdAt = LocalDateTime.now();

}