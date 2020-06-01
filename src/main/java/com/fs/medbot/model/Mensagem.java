package com.fs.medbot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mensagem {
    
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    String intent;
    String information;
    String product;
    
    public Mensagem(String intent, String information, String product) {
		super();
		this.intent = intent;
		this.information = information;
		this.product = product;
	}
  
}