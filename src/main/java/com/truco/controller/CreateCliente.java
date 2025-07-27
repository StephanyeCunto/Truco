package com.truco.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Scanner;

import com.truco.model.Carta;
import com.truco.model.Cliente;
import com.truco.service.*;

public class CreateCliente extends UnicastRemoteObject implements InterfaceCliente {
    private ClienteService clienteService;
    private List<Carta> mao;
    private String name;

    public CreateCliente(String name) throws RemoteException {
        super();
        this.name = name;
        Cliente cliente = new Cliente("192.168.1.7", "Ste", 1099);
        clienteService = new ClienteService(cliente.getUri(), name);
        
        clienteService.registrarCliente(name, this);
        
        clienteService.solicitarMao(name);
    }

    @Override
    public void getMao(List<Carta> mao) throws RemoteException {
        this.mao = mao;
        System.out.println("Cartas recebidas do servidor!");
    }

    public List<Carta> getMaoAtual() {
        return mao;
    }

    public void jogarCarta(Carta carta) {
        try {
            clienteService.jogarCarta(carta, name);
            mao.remove(carta);
        } catch (Exception e) {
            System.err.println("Erro ao jogar carta: " + e);
            e.printStackTrace();
        }
    }

    public Carta jogarCarta(){
        printCartas();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Carta carta = mao.get(choice);
        jogarCarta(mao.get(choice));
        System.out.println(carta);
        return carta;
    }

    private void printCartas(){
        if (mao != null && !mao.isEmpty()) {
            System.out.println("Suas cartas:");
            for (int i = 0; i < mao.size(); i++)  System.out.println(i + " - " + mao.get(i).getCarta());
        } else System.out.println("Você não possui cartas ainda.");
    }
}