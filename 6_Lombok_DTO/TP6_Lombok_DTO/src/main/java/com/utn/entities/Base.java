package com.utn.entities;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;

@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public abstract class Base {

    protected static long idCounter = 0;

    @Builder.Default
    protected long id = idCounter ++;
    @Builder.Default
    protected boolean eliminado = false;
    @Builder.Default
    protected LocalDateTime createdAt = LocalDateTime.now();
}