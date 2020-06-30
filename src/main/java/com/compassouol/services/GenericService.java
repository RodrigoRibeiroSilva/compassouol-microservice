package com.compassouol.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.compassouol.domain.BaseObject;
import com.compassouol.repositories.GenericRepository;
import com.compassouol.services.exceptions.DataIntegrityException;
import com.compassouol.services.exceptions.ObjectNotFoundException;


public class GenericService<E extends BaseObject> {
	
	@Autowired
	protected GenericRepository<E> repository;
	
	public Page<E> buscar(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public E buscarPorId(Long id) {
		Optional<E> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException());
	}
	
	public E inserir(E dto) {
		return repository.save(dto);
	}
	
	public E atualizar(E obj, Long id) {
		E objEncontrado = buscarPorId(id);
		objEncontrado = obj;
		return repository.save(objEncontrado);
	}
		
	public void deletar(Long id) {
		buscarPorId(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir esse registro");
		}	
	}
}
