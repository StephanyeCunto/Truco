package com.truco.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.truco.model.Carta;

public interface InterfaceCliente extends Remote{
    void getMao(List<Carta> mao) throws RemoteException;

    Carta jogarCarta()throws RemoteException;
}
