package com.compassouol.repositories;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.compassouol.domain.Cidade;

public interface CidadeRepository extends GenericRepository<Cidade>{
	
	@Transactional(readOnly=true)
	Optional<Cidade> findByNome(String nome);
	
	@Transactional(readOnly=true)
	Optional<Cidade> findByEstado(String estado);
}
