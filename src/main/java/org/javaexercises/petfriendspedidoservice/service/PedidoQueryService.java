package org.javaexercises.petfriendspedidoservice.service;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.javaexercises.petfriendspedidoservice.model.Pedido;
import org.javaexercises.petfriendspedidoservice.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoQueryService {

    private final EventStore eventStore;
    private PedidoRepository pedidoRepository;

    public PedidoQueryService(EventStore eventStore, PedidoRepository pedidoRepository) {
        this.eventStore = eventStore;
        this.pedidoRepository = pedidoRepository;
    }

    public List<Object> listarEventos(String id) {
        List<Object> listaEventos = eventStore.readEvents(id, 0)
                .asStream()
                .map(record -> record.getPayload()).collect(Collectors.toList());

        return listaEventos;
    }

    public Optional<Pedido> obterPedidoPorId(String id) {
        return pedidoRepository.findById(id);
    }
}
