package com.fs.medbot.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fs.medbot.model.Pedido;
import com.fs.medbot.repository.PedidoRepostiory;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	PedidoRepostiory repository;

	@PostMapping
	@Transactional
	public ResponseEntity<Pedido> save(@RequestBody Pedido pedidorecebido) {
		
		String check=pedidorecebido.getStatus();
		System.out.println(check);
		if (check.equals("carencia")) {
			System.out.println("entrou no if");
			return null;
			
		} else {
			repository.save(pedidorecebido);
			System.out.println("entrou no else");
			return new ResponseEntity<Pedido>(pedidorecebido, HttpStatus.CREATED);
			
		}
	}
}
