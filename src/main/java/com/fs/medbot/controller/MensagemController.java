package com.fs.medbot.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fs.medbot.model.Mensagem;
import com.fs.medbot.repository.DialogoRepository;
import com.fs.medbot.repository.MensagemRepository;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {
	@Autowired
	MensagemRepository repository;
	DialogoRepository dialogrepository;

	@GetMapping
	@Transactional
	public ResponseEntity<?> save(@RequestBody Mensagem mensagemrecebida) {
		List<Mensagem> mensagemexiste = repository.findByInformationAndProduct(mensagemrecebida.getInformation(),
				mensagemrecebida.getProduct());
		System.out.println(mensagemexiste);
		if (mensagemexiste.isEmpty()) {
			System.out.println("não achou");
			List<Mensagem> prod = repository.findByProduct(mensagemrecebida.getProduct());
			List<Mensagem> info = repository.findByInformation(mensagemrecebida.getInformation());
			System.out.println(prod);
			System.out.println(info);
			if (prod.isEmpty() && info.isEmpty()) {
				System.out.println("nenhum");
				return ResponseEntity.ok("Não possuo nem este produto, nem esta informação");
			} else {
				if (info.isEmpty()) {
					System.out.println("informacao");
					return ResponseEntity.ok("Possuo este produto mas não esta informação");
				} else {
					System.out.println("produto");
					return ResponseEntity.ok("Possuo esta informação mas não este produto");
				}
			}
		} else {
			System.out.println("else");
			return ResponseEntity.ok(mensagemexiste);
		}

	}
	
	

}
