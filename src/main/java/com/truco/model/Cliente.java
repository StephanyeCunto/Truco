package com.truco.model;

import lombok.*;

@Getter
@AllArgsConstructor
public class Cliente {
    private String host, service;
    private int port;

    public String getUri(){
        return "rmi://"+host+":"+port+"/"+service;
    }
}
