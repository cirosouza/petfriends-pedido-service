package org.javaexercises.petfriendspedidoservice.event;

import java.time.LocalDateTime;

public class PedidoCriado extends BaseEvent<String>{

    public final double valor;
    public final String loja;

    public PedidoCriado(String id, LocalDateTime timestamp, double valor, String loja) {
        super(id, timestamp);
        this.valor = valor;
        this.loja = loja;
    }

}
