package com.truco.controller;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.truco.service.InterfaceMesa;
import com.truco.service.Servidor;

public class CreateServidor {
    public CreateServidor(){
        try {
            LocateRegistry.createRegistry(1099);
            System.setProperty("java.rmi.serve.hostname","192.168.1.7");

            InterfaceMesa mesa = new Servidor();
            Naming.rebind("Ste", mesa);
            System.out.println("Servidor registrado como 'Ste'");
        } catch (Exception e) {
            System.err.println("Erro ao iniciar servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
