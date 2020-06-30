package com.compassouol.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.compassouol.domain.Cliente;
import com.compassouol.dto.AtualizarClienteDTO;
import com.compassouol.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource extends GenericResource<Cliente>{
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> buscarClientePeloNome(@PathVariable(value = "nome") String nome) {
		List<Cliente> obj = clienteService.buscarClientePeloNome(nome);
		return ResponseEntity.ok().body(obj);
	}
	
	@PatchMapping("/modificarNome/{id}")
	public ResponseEntity<?> alterarNome(
	  @RequestBody AtualizarClienteDTO clienteDTO, @PathVariable("id") String id) {
	    clienteService.alterarNome(clienteDTO, Long.valueOf(id));
	    return ResponseEntity.ok("Registro atualizado com sucesso.");
	}
}
