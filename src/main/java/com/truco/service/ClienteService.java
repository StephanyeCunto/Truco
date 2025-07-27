package com.truco.service;

import java.rmi.*;

import com.truco.model.Carta;

public class ClienteService {
    private InterfaceMesa service;

    public ClienteService(String rmi, String nome){
        try{
            service = (InterfaceMesa) Naming.lookup(rmi);
        }catch (RemoteException e) {
            System.err.println("ServiceClient RemoteException: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("ServiceClient exception: " + e.toString());
            e.printStackTrace();
        }

    }

    public void registrarCliente(String nome, InterfaceCliente cliente) throws RemoteException {
        service.registrarCliente(nome, cliente);
    }

    public void solicitarMao(String nome) throws RemoteException {
        service.getMao(nome);
    }

    public void jogarCarta(Carta carta, String name) throws RemoteException{
        service.jogarCarta(carta,name);
    }
}