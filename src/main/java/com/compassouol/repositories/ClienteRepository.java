package com.compassouol.repositories;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.compassouol.domain.Cliente;

public interface ClienteRepository extends GenericRepository<Cliente>{
	
	@Transactional(readOnly=true)
	Optional<Cliente> findByNome(String nome);
}
