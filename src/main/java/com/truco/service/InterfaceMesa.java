package com.truco.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.truco.model.Carta;

public interface InterfaceMesa extends Remote {
    List<Carta> getMao() throws RemoteException;
}
