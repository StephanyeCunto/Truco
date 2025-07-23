package com.truco.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Carta {
    private final Naipe naipe;
    private final ValorCarta valor;
}
