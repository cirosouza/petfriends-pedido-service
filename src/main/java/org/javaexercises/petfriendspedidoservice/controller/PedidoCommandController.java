package org.javaexercises.petfriendspedidoservice.controller;

import org.javaexercises.petfriendspedidoservice.model.Pedido;
import org.javaexercises.petfriendspedidoservice.service.PedidoCommandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoCommandController {

    private final PedidoCommandService pedidoCommandService;

    public PedidoCommandController(PedidoCommandService pedidoCommandService) {
        this.pedidoCommandService = pedidoCommandService;
    }

    @PostMapping
    public CompletableFuture<String> criarPedido(@RequestBody Pedido pedido) {
        return pedidoCommandService.criarPedido(pedido);
    }
}
