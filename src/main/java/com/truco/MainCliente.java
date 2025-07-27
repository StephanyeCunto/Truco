package com.truco;

import java.util.*;

import com.truco.controller.CreateCliente;
import com.truco.model.Carta;

public class MainCliente {
    public static void main(String[] args) {
        System.out.println("Digite seu nome: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        CreateCliente cliente = new CreateCliente(name);

        int verificador = 1;
        do{
            System.out.println("O que deseja fazer: ");
            System.out.println("0 - Sair ");
            System.out.println("1 - Ver minhas cartas ");
            System.out.println("2 - Jogar carta ");
            verificador = scanner.nextInt();

            if(verificador == 1){
                List<Carta> mao = cliente.getMao();
                for(Carta carta : mao){
                    System.out.println("Minhas cartas: "+ carta.getCarta());
                }
            }
            if(verificador == 2){
                System.out.println("Digite o numero da carta ");
                int carta = scanner.nextInt();
                List<Carta> mao = cliente.getMao();
                cliente.jogarCarta(mao.get(carta));
            } 
        }while(verificador != 0);

        scanner.close();
    }
}
