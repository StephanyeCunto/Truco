package com.truco.controller;

import java.util.List;

import com.truco.model.Carta;
import com.truco.model.Cliente;
import com.truco.service.*;

public class CreateCliente {
    public CreateCliente(){
        Cliente cliente = new Cliente("192.168.1.8", "Ste", 1099);

        initClient(cliente);
    }

    private void initClient(Cliente cliente){
            ClienteService clienteService = new  ClienteService(cliente.getUri());
        try{
            List<Carta> mao = clienteService.getMao();
            for (Carta c : mao) {
                System.out.println("Valor: "+c.getValor()+" Naipe: "+ c.getNaipe());
            }
        }catch (Exception e) {
            System.err.println("Client erro: "+ e);
        }
    }
}
