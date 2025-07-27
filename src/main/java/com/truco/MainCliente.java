package com.truco;

import java.util.*;
import com.truco.controller.CreateCliente;
import com.truco.model.Carta;

public class MainCliente {
    public static void main(String[] args) {
        System.out.println("Digite seu nome: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        
        CreateCliente cliente;
        try {
            cliente = new CreateCliente(name);
            System.out.println("Cliente conectado com sucesso!");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println("Erro ao criar cliente: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        int verificador = 1;
        do {
            System.out.println("\nO que deseja fazer: ");
            System.out.println("0 - Sair ");
            System.out.println("1 - Ver minhas cartas ");
            verificador = scanner.nextInt();

            if (verificador == 1) {
                List<Carta> mao = cliente.getMaoAtual();
                if (mao != null && !mao.isEmpty()) {
                    System.out.println("Suas cartas:");
                    for (int i = 0; i < mao.size(); i++)  System.out.println(i + " - " + mao.get(i).getCarta());
                } else System.out.println("Você não possui cartas ainda.");
            }
        } while (verificador != 0);

        scanner.close();
    }
}