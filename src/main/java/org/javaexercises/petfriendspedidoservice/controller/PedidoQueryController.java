package org.javaexercises.petfriendspedidoservice.controller;

import org.javaexercises.petfriendspedidoservice.model.Pedido;
import org.javaexercises.petfriendspedidoservice.service.PedidoQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoQueryController {

    private final PedidoQueryService pedidoQueryService;

    public PedidoQueryController(PedidoQueryService pedidoQueryService) {
        this.pedidoQueryService = pedidoQueryService;
    }

    @GetMapping("/{id}/eventos")
    public List<Object> listarEventos(@PathVariable("id") String id) {
        return pedidoQueryService.listarEventos(id);
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable("id") String id) {
        return pedidoQueryService.obterPedidoPorId(id).get();
    }
}
