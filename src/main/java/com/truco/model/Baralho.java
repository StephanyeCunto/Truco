package com.truco.model;

import java.util.*;
import lombok.Getter;

@Getter
public class Baralho {
    private final List<Carta> cartas = new ArrayList<>();

    public Baralho(){
        for(Naipe naipe : Naipe.values()){
            for (ValorCarta valor : ValorCarta.values()){
                if(checkCarta(naipe,valor)) cartas.add(new Carta(naipe, valor));
            }
        }
        Collections.shuffle(cartas);
    }

    private boolean checkCarta(Naipe naipe, ValorCarta valor){
        if(valor == ValorCarta.QUATRO && naipe != Naipe.PAUS) return false;
        else if(valor == ValorCarta.AESPADAS && naipe != Naipe.ESPADAS) return false;
        else if(valor == ValorCarta.SETECOPAS && naipe != Naipe.COPAS) return false;
        else if(valor == ValorCarta.SETEOUROS && naipe != Naipe.OUROS) return false;
        else if(valor == ValorCarta.A && naipe == Naipe.ESPADAS) return false;
        else return true;
    }

    public List<Carta> distribuirMao() {
        List<Carta> mao = new ArrayList<>();
        do{
            mao.removeAll(mao);
            for (int i = 0; i < 3; i++) {
                mao.add(cartas.get(0));
                cartas.remove(0);
            }
        }while(checkFamilia(mao));
 
        return mao;
    }

    private boolean checkFamilia(List<Carta> mao){
        for(Carta carta : mao){
            if(carta.getValor() != ValorCarta.A && carta.getValor() != ValorCarta.K && carta.getValor() != ValorCarta.J && carta.getValor() != ValorCarta.Q) return false;
        }
        return true;
    }

}
