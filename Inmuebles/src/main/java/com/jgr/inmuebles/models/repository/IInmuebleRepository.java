package com.jgr.inmuebles.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.jgr.inmuebles.models.entity.Inmueble;

public interface IInmuebleRepository extends CrudRepository<Inmueble,Long>{
	
	

}
