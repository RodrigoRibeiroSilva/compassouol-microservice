package com.compassouol.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.compassouol.domain.BaseObject;

@Repository
public interface GenericRepository<E extends BaseObject> extends PagingAndSortingRepository<E, Long>{
	
}
