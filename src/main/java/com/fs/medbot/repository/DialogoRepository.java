package com.fs.medbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fs.medbot.model.Dialogo;

@Repository
public interface DialogoRepository extends JpaRepository<Dialogo, Long>{
	public Dialogo findById(final String id);
}
