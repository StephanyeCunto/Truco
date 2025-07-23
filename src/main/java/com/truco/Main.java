package com.truco;

import java.util.ArrayList;
import java.util.List;

import com.truco.model.Baralho;
import com.truco.model.Carta;

public class Main{
    public static void main(String[] args) {
        Baralho b = new Baralho();
        List<Carta> cartas =  b.getCartas();

        for(Carta carta :cartas){
            System.out.println("Get cartas: "+carta.getNaipe() + " "+carta.getValor());
        }
        for(int i=0; i<3; i++){
                List<Carta> cartasMao =  b.distribuirMao();
                for(Carta carta :cartasMao){
                    System.out.println("Get cartas Mão "+i+" : "+carta.getNaipe() + " "+carta.getValor()+ " "+carta.getValor().getValorNumerico());
                }
            }
        }
}