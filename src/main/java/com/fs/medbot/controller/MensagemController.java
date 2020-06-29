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

	@GetMapping
	@Transactional
	public ResponseEntity<List<Mensagem>> save(@RequestBody Mensagem mensagemrecebida) {
		List<Mensagem> listamensagem = null;
		List<Mensagem> mensagemexiste = repository.findByInformationAndProduct(mensagemrecebida.getInformation(), mensagemrecebida.getProduct());
		
		if (mensagemexiste.equals(null)) 
		{
			List<Mensagem> prod = repository.buscarProd(mensagemrecebida.getInformation());
			List<Mensagem> info = repository.buscarInfo(mensagemrecebida.getProduct());
			if(prod.equals(null)&&info.equals(null))
			{
				System.out.println("nenhum");
			}
			else
			{
				if(info.equals(null))
				{
					System.out.println("informacao");
				}
				else 
				{
					System.out.println("produto");
				}
			}
			return null;
		}
		else 
		{	
			//repository.save(mensagemrecebida);
			listamensagem = repository.findByInformationAndProduct(mensagemrecebida.getInformation(),mensagemrecebida.getProduct());
			return ResponseEntity.ok(listamensagem);
		}
		
	}

}
