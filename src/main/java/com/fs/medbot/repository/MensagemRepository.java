package com.fs.medbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fs.medbot.model.Mensagem;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
	/*@Query(value = "Select * from mensagem m where intent=:abacaxi and information=:dois and product=:tres", nativeQuery = true)
	public Mensagem buscarMensagemNativa(@Param("abacaxi") final String intent, @Param("dois") final String information,
			@Param("tres") final String product);

	@Query("Select m from Mensagem m where intent=:abacaxi and information=:dois and product=:tres")
	public Mensagem buscarMensagem(@Param("abacaxi") final String intent, @Param("dois") final String information,
			@Param("tres") final String product);

	public Mensagem findByInformationAndIntentAndProduct(final String information, final String intent,
			final String product);*/
	
	public List<Mensagem> findByInformationAndProduct(final String information,final String product);
	
	@Query(value = "Select m.product from mensagem m where product=:prod", nativeQuery = true)
	public List<Mensagem> buscarProd(@Param("prod") final String product);
	
	@Query(value = "Select m.information from mensagem m where information=:info", nativeQuery = true)
	public List<Mensagem> buscarInfo(@Param("info") final String information);
	
}
