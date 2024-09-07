package org.javaexercises.petfriendspedidoservice.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.javaexercises.petfriendspedidoservice.command.CriarPedidoCommand;
import org.javaexercises.petfriendspedidoservice.event.PedidoCriado;
import jakarta.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Aggregate
@Data
@Entity
public class Pedido {

    @AggregateIdentifier
    @Id
    private String id;
    private double valor;
    private String loja;
    private StatusPedido status;

    @CommandHandler
    public Pedido(CriarPedidoCommand comando){
        AggregateLifecycle.apply(new PedidoCriado(comando.id, comando.timestamp, comando.valor, comando.loja));
    }

    @EventSourcingHandler
    protected void on(PedidoCriado event){
        this.id = event.id;
        this.valor = event.valor;
        this.loja = event.loja;

        AggregateLifecycle.apply(this.status = StatusPedido.CRIADO);
    }

}
