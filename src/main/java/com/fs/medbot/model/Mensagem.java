package com.fs.medbot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="mensagem",schema="public")
public class Mensagem {
    
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "information")
    private String information;
	
	@Column(name = "intent")
    private String intent;
	
	@Column(name = "product")
    private String product;
	
	@Column(name="text")
	private String msgBot;
	
    
   
  
}