package com.compassouol.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.compassouol.domain.BaseObject;
import com.compassouol.services.GenericService;

public class GenericResource<E extends BaseObject> {

	@Autowired
	protected GenericService<E> service;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<E> buscar(Pageable pageable) {
		Page<E> page = (Page<E>) service.buscar(pageable);
		return page;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public E buscarPorId(@PathVariable(value = "id") Long id) {
		return service.buscarPorId(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<E> inserir(@RequestBody E entity) {
		service.inserir(entity);
		return ResponseEntity.ok().body(entity);

	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<E> atualizar(@PathVariable(value = "id") Long id, @RequestBody E entity) {
		service.atualizar(entity, id);
		return ResponseEntity.ok().body(entity);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable(value = "id") Long id) {
		service.deletar(id);
	}
}
