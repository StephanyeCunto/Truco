package com.truco.controller;

import java.util.List;

import com.truco.model.Carta;
import com.truco.model.Cliente;
import com.truco.service.*;

public class CreateCliente {
    private ClienteService clienteService;

    private List<Carta> mao;

    private String name;

    public CreateCliente(String name){
        this.name = name;
        Cliente cliente = new Cliente("192.168.1.7", "Ste", 1099);
        clienteService = new  ClienteService(cliente.getUri(), name);
    }

    public List<Carta> getMao(){
        try{
         //   if(mao == null || mao.isEmpty()) mao = clienteService.getMao();
            return mao;
        }catch (Exception e) {
            System.err.println("Client erro carregar Cartas: "+ e);
            e.printStackTrace();
        }
        return mao;
    }

    public void jogarCarta(Carta carta){
        try{
            clienteService.jogarCarta(carta, name);
        }catch (Exception e) {
            System.err.println("Client erro jogar Cartas: "+ e);
            e.printStackTrace();
        }
        mao.remove(carta);
    }
}
