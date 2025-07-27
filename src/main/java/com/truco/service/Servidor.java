package com.truco.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import com.truco.model.*;

public class Servidor extends UnicastRemoteObject implements InterfaceMesa{
    private Map<String, InterfaceCliente> clientes = new HashMap<>();

    private Baralho baralho;
    private HashMap<Carta,String> cartasJogadas = new HashMap<>();

    public Servidor() throws RemoteException {
        super(); 
        baralho = new Baralho();
    }

    @Override
    public void getMao(String name) throws RemoteException{
        InterfaceCliente cliente = clientes.get(name);
        cliente.getMao(baralho.distribuirMao());
    } 

    @Override
    public void jogarCarta(Carta carta, String name){
        cartasJogadas.put(carta,name);
        System.out.println(name+" jogou a carta: "+ carta.getCarta());
    }   

    @Override
    public void registrarCliente(String nome, InterfaceCliente cliente) throws RemoteException {
        clientes.put(nome, cliente);
        System.out.println("Cliente registrado: " + nome);
        if(clientes.size()>= 2){
            escolheJogador();
        }
    }

    public void escolheJogador() throws RemoteException{
        for(Map.Entry<String, InterfaceCliente> entry : clientes.entrySet()){
            System.out.println("Vez do: "+ entry.getKey());
            getMao(entry.getKey());
            entry.getValue().jogarCarta();
        }

        HashMap<Carta,String> ganhador = new HashMap<>();
        for(Map.Entry<Carta,String> entry : cartasJogadas.entrySet()){
            System.out.println("Carta Jogada: "+entry.getKey().getValor()+" "+ entry.getKey().getNaipe());
            if(ganhador == null) ganhador.put(entry.getKey(), entry.getValue());
            else if((int) ganhador.entrySet().iterator().next().getKey().getValorNumerico() < (int) entry.getKey().getValorNumerico())
        }
    }
}
