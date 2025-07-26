package com.truco.model;

import java.io.Serializable;

import lombok.*;

@AllArgsConstructor
@Getter
public class Carta implements Serializable{
    private static final long serialVersionUID = 1L;

    private final Naipe naipe;
    private final ValorCarta valor;
}
