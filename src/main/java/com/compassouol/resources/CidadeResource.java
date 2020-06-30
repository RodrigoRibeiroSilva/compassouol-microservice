package com.compassouol.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.compassouol.domain.Cidade;
import com.compassouol.services.CidadeService;

@RestController
@RequestMapping(value="/cidades")
public class CidadeResource extends GenericResource<Cidade>{
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Cidade> buscarCidadePeloNome(@PathVariable(value = "nome") String nome) {
		Cidade  obj = cidadeService.buscarCidadePeloNome(nome);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/estado/{estado}", method = RequestMethod.GET)
	public ResponseEntity<Cidade> buscarCidadePeloEstado(@PathVariable(value= "estado") String estado) {
		Cidade obj = cidadeService.buscarCidadePeloEstado(estado);
		return ResponseEntity.ok().body(obj);
	}

}
