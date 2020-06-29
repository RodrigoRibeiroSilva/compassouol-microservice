package com.compassouol.repositories;

import org.springframework.transaction.annotation.Transactional;

import com.compassouol.domain.Cidade;

public interface CidadeRepository extends GenericRepository<Cidade>{
	
	@Transactional(readOnly=true)
	Cidade findByNome(String nome);
	
	@Transactional(readOnly=true)
	Cidade findByEstado(String estado);
}
