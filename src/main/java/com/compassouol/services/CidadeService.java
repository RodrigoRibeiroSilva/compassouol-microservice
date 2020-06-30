package com.compassouol.services;

import java.util.List;
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

	public List<Cidade> buscarCidadePeloNome(String nome) {
		Optional<List<Cidade>> obj = cidadeRepository.findByNome(nome);
		return obj.orElseThrow(() -> new ObjectNotFoundException());
	}
	
	public List<Cidade> buscarCidadePeloEstado(String estado) {
		Optional<List<Cidade>> obj = cidadeRepository.findByEstado(estado);
		return obj.orElseThrow(() -> new ObjectNotFoundException());
	}
}
