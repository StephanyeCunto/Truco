package com.truco.model;

import lombok.*;

@Getter
@AllArgsConstructor
public enum ValorCarta {
    Q(1), J(2), K(3), A(4), DOIS(5), TRÊS(6), SETE(7), QUATRO(8);
    
    private final int valorNumerico;
}
