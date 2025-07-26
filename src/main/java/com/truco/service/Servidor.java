package com.truco.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import com.truco.model.*;

public class Servidor extends UnicastRemoteObject implements InterfaceMesa{
    private Baralho baralho;

   public Servidor() throws RemoteException {
        super(); 
        baralho = new Baralho();
    }

    public List<Carta> getMao(){
        return baralho.distribuirMao();
    } 

    public void jogarCarta(Carta carta){
        System.out.println("Carta jogada: "+ carta.getValor()+" "+carta.getNaipe());
    }
}
