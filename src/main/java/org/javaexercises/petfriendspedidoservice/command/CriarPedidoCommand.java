package org.javaexercises.petfriendspedidoservice.command;

import java.time.LocalDateTime;

public class CriarPedidoCommand extends BaseCommand<String> {

    public final String loja;
    public final double valor;
    public LocalDateTime timestamp;


    public CriarPedidoCommand(String id, String loja, double valor) {
        super(id);
        this.loja = loja;
        this.valor = valor;
        this.timestamp = LocalDateTime.now();
    }
}
