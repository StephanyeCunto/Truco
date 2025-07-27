package com.truco.service;

import java.rmi.*;
import java.util.List;

import com.truco.model.Carta;

public interface InterfaceMesa extends Remote {
   void getMao(String name) throws RemoteException;

    void jogarCarta(Carta carta, String name) throws RemoteException;

    void registrarCliente(String nome, InterfaceCliente cliente) throws RemoteException;
}
