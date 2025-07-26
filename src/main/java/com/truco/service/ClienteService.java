package com.truco.service;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import com.truco.model.Carta;

public class ClienteService {
    private InterfaceMesa service;

    public ClienteService(String rmi){
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

    public  List<Carta> getMao() throws RemoteException{
        return service.getMao();
    }
}