package com.compassouol.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.compassouol.domain.BaseObject;
import com.compassouol.services.GenericService;

public class GenericResource<E extends BaseObject> {

	@Autowired
	protected GenericService<E> service;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public Page<E> list(Pageable pageable) {
		Page<E> page = (Page<E>) service.findAll(pageable);
		return page;
	}
	
	@CrossOrigin
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public E get(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<E> insert(@RequestBody E entity) {
		service.insert(entity);
		return ResponseEntity.ok().body(entity);

	}
	
	@CrossOrigin
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<E> update(@PathVariable(value = "id") Long id, @RequestBody E entity) {
		service.update(entity, id);
		return ResponseEntity.ok().body(entity);
	}
	
	@CrossOrigin
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}
}
