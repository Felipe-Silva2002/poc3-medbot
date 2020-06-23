package com.fs.medbot.controller;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fs.medbot.model.Mensagem;
import com.fs.medbot.repository.MensagemRepository;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {
	@Autowired
	MensagemRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<List<Mensagem>> save(@RequestBody Mensagem mensagemrecebida) {
		List<Mensagem> listamensagem = null;
		Mensagem mensagemexiste = repository.findByInformationAndIntentAndProduct(mensagemrecebida.getInformation(),
				mensagemrecebida.getIntent(), mensagemrecebida.getProduct());
		if (mensagemexiste == null) {
			repository.save(mensagemrecebida);
		}

		listamensagem = repository.findByInformation(mensagemrecebida.getInformation());
		return ResponseEntity.ok(listamensagem);
	}

}
