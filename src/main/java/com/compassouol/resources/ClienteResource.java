package com.compassouol.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.compassouol.domain.Cliente;
import com.compassouol.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource extends GenericResource<Cliente>{
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findByNome(@PathVariable(value = "nome") String nome) {
		Cliente obj = clienteService.findByNome(nome);
		return ResponseEntity.ok().body(obj);
	}
}
