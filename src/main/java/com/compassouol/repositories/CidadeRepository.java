package com.compassouol.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.compassouol.domain.Cidade;

public interface CidadeRepository extends GenericRepository<Cidade>{
	
	@Transactional(readOnly=true)
	Optional<List<Cidade>> findByNome(String nome);
	
	@Transactional(readOnly=true)
	Optional<List<Cidade>> findByEstado(String estado);
}
