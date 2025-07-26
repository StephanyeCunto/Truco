package com.truco.service;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

import com.truco.model.*;
public class teste {
        private Cliente cliente;

        public void startHost() {
        try {
            System.setProperty("java.rmi.serve.hostname", cliente.getHost());

            //List<Carta> Mao = new ArrayList<Carta>();

          //  Mao mao = new Mao();

            String rmi = ("rmi://" + cliente.getHost() + ":" + cliente.getPort() + "/getMao");
          //  Naming.rebind(rmi, mao);

        } catch (Exception e) {
            System.err.println("ServiceHost exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
