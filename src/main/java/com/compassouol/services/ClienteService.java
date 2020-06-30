package com.compassouol.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassouol.domain.Cidade;
import com.compassouol.domain.Cliente;
import com.compassouol.repositories.ClienteRepository;
import com.compassouol.services.exceptions.DataIntegrityException;
import com.compassouol.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService extends GenericService<Cliente> {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private CidadeService cidadeService;

	@Override
	@Transactional
	public Cliente insert(Cliente cliente) {
		try {
			Cidade cidade = cidadeService.findByNome(cliente.getCidade().getNome());
			cliente.setCidade(cidade);
			return repo.save(cliente);
		} catch (ObjectNotFoundException e) {
			throw new DataIntegrityException("Cidade inválida");
		}

	}

	public Cliente findByNome(String nome) {
		Optional<Cliente> cliente = clienteRepository.findByNome(nome);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Registro não encontrado."));
	}
}
