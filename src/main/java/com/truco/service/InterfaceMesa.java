package com.truco.service;

import java.rmi.*;
import java.util.List;

import com.truco.model.Carta;

public interface InterfaceMesa extends Remote {
    List<Carta> getMao() throws RemoteException;

    void jogarCarta(Carta carta) throws RemoteException;
}
