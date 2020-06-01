package com.fs.medbot.controller;

import java.util.HashMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public HashMap<String, Object> save(@RequestBody Mensagem mensagem){
		
		repository.save(mensagem);
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("inf_text", "Você me passou estes dados para pesquisa:"+mensagem.getProduct()+"/"+mensagem.getInformation());
		map.put("inf_type", "Hello World");
		
		return map;
	
	}
	
}

