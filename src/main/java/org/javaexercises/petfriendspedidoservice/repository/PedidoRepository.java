package org.javaexercises.petfriendspedidoservice.repository;

import org.javaexercises.petfriendspedidoservice.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, String> {
}
