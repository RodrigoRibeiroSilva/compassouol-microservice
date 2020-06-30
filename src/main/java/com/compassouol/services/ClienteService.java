package com.compassouol.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassouol.domain.Cidade;
import com.compassouol.domain.Cliente;
import com.compassouol.dto.AtualizarClienteDTO;
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
	public Cliente inserir(Cliente cliente) {
		try {
			Cidade cidade = cidadeService.buscarPorId(cliente.getCidade().getId());
			cliente.setCidade(cidade);
			return repository.save(cliente);
		} catch (ObjectNotFoundException e) {
			throw new DataIntegrityException("Cidade inválida");
		}

	}

	public List<Cliente> buscarClientePeloNome(String nome) {
		Optional<List<Cliente>> cliente = clienteRepository.findByNome(nome);
		return cliente.orElseThrow(() -> new ObjectNotFoundException());
	}

	public void alterarNome(AtualizarClienteDTO clienteDTO, Long id) {
		Cliente clienteModificado = buscarPorId(id);
		clienteModificado.setNome(clienteDTO.getNome());
		atualizar(clienteModificado, id);
	}
}
