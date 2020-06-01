package com.fs.medbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fs.medbot.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long>{

}
