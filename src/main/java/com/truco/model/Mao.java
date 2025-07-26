package com.truco.model;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@NoArgsConstructor
@Getter
public class Mao {
    private final List<Carta> cartas = new ArrayList<>();
}
