package com.truco.model;

import java.util.*;
import lombok.Getter;

@Getter
public class Baralho {
    private final List<Carta> cartas = new ArrayList<>();

    public Baralho(){
        for(Naipe naipe : Naipe.values()){
            for (ValorCarta valor : ValorCarta.values()){
                if(valor == ValorCarta.SETE) {
                    if(naipe == Naipe.COPAS || naipe == Naipe.ESPADAS) cartas.add(new Carta(naipe, valor));
                }
                else if(valor == ValorCarta.QUATRO) {
                    if(naipe == Naipe.PAUS) cartas.add(new Carta(naipe, valor));
                }
                else cartas.add(new Carta(naipe, valor));
            }
        }
        Collections.shuffle(cartas);
    }

    public List<Carta> distribuirMao() {
        List<Carta> mao = new ArrayList<>();
        do{
            for (int i = 0; i < 3; i++) {
                mao.add(cartas.get(0));
                cartas.remove(0);
            }
        }while(checkFamilia(mao));
 
        return mao;
    }

    private boolean checkFamilia(List<Carta> mao){
        for(Carta carta : mao){
            if(carta.getValor() != ValorCarta.A && carta.getValor() != ValorCarta.K && carta.getValor() != ValorCarta.J && carta.getValor() != ValorCarta.Q){
                return false;
            }
        }
        return true;
    }

}
