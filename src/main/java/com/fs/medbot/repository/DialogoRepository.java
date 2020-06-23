package com.fs.medbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fs.medbot.model.Dialogo;


public interface DialogoRepository extends JpaRepository<Dialogo, Long>{
	
}
