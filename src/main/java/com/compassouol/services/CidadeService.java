package com.compassouol.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassouol.domain.Cidade;
import com.compassouol.repositories.CidadeRepository;
import com.compassouol.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService extends GenericService<Cidade> {

	@Autowired
	private CidadeRepository cidadeRepository;

	public Cidade buscarCidadePeloNome(String nome) {
		Optional<Cidade> obj = cidadeRepository.findByNome(nome);
		return obj.orElseThrow(() -> new ObjectNotFoundException());
	}
	
	public Cidade buscarCidadePeloEstado(String estado) {
		Optional<Cidade> obj = cidadeRepository.findByEstado(estado);
		return obj.orElseThrow(() -> new ObjectNotFoundException());
	}
}
