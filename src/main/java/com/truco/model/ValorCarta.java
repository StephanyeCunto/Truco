package com.truco.model;

import lombok.*;

@Getter
@AllArgsConstructor
public enum ValorCarta {
    Q(1), J(2), K(3), A(4), DOIS(5), TRÊS(6), SETEOUROS(7), AESPADAS(8), SETECOPAS(9) , QUATRO(10);

    private final int valorNumerico;
}
