package com.truco;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.truco.service.InterfaceMesa;
import com.truco.service.Servidor;

import com.truco.controller.*;

public class Main{
    public static void main(String[] args) {
        try {

            LocateRegistry.createRegistry(1099);
            System.setProperty("java.rmi.serve.hostname","192.168.1.8");

            System.out.println("RMI Registry iniciado na porta 1099");

            InterfaceMesa mesa = new Servidor();

           Naming.rebind("Ste", mesa);
            System.out.println("Servidor registrado como 'Ste'");
        } catch (Exception e) {
            System.err.println("Erro ao iniciar servidor: " + e.getMessage());
            e.printStackTrace();
        }

       CreateCliente cliente = new CreateCliente();
    }
}