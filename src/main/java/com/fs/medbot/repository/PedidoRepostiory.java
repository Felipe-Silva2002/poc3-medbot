package com.fs.medbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fs.medbot.model.Pedido;

@Repository
public interface PedidoRepostiory extends JpaRepository<Pedido, Long> {
	public Pedido findById(final String id);
}
