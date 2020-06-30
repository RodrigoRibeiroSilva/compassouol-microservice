package com.compassouol.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.compassouol.domain.Cliente;

public interface ClienteRepository extends GenericRepository<Cliente>{
	
	@Transactional(readOnly=true)
	Optional<List<Cliente>> findByNome(String nome);
}
