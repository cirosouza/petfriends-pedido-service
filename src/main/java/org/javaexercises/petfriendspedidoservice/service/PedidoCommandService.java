package org.javaexercises.petfriendspedidoservice.service;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.javaexercises.petfriendspedidoservice.command.CriarPedidoCommand;
import org.javaexercises.petfriendspedidoservice.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class PedidoCommandService {

    @Autowired
    private final CommandGateway commandGateway;

    public PedidoCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> criarPedido(Pedido pedido){
        return commandGateway.send(
                new CriarPedidoCommand(
                        UUID.randomUUID().toString(),
                        pedido.getLoja(),
                        pedido.getValor()));
    }
}
