package com.truco.controller;

import java.util.List;

import com.truco.model.Carta;
import com.truco.model.Cliente;
import com.truco.service.*;

public class CreateCliente {
    ClienteService clienteService;

    List<Carta> mao;

    public CreateCliente(){
        Cliente cliente = new Cliente("192.168.1.7", "Ste", 1099);
        clienteService = new  ClienteService(cliente.getUri());
    }

    public void getMao(){
        try{
            mao = clienteService.getMao();
            for (Carta c : mao) {
                System.out.println("Minhas cartas: "+c.getValor()+" "+c.getNaipe());
            }
        }catch (Exception e) {
            System.err.println("Client erro: "+ e);
        }
    }

    public void jogarCarta(Carta carta){
        try{
            clienteService.jogarCarta(carta);
        }catch (Exception e) {
            System.err.println("Client erro: "+ e);
        }
        mao.remove(carta);
    }
}
