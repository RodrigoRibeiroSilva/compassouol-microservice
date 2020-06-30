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
	protected GenericRepository<E> repo;
	
	public Page<E> findAll(Pageable pageable){
		return repo.findAll(pageable);
	}
	
	public E findById(Long id) {
		Optional<E> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Registro não encontrado."));
	}
	
	public E insert(E dto) {
		return repo.save(dto);
	}
	
	public E update(E obj, Long id) {
		E objTracked = findById(id);
		objTracked = obj;
		return repo.save(objTracked);
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir esse registro");
		}	
	}
}
