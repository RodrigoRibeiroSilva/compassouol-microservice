package com.compassouol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassouol.domain.Cidade;
import com.compassouol.repositories.CidadeRepository;

@Service
public class CidadeService extends GenericService<Cidade> {

	@Autowired
	private CidadeRepository cidadeRepository;

	public Cidade findByNome(String nome) {
		return cidadeRepository.findByNome(nome);
	}
	
	public Cidade findByEstado(String estado) {
		return cidadeRepository.findByEstado(estado);
	}
}
