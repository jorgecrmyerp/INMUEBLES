package com.jgr.inmuebles.models.service;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

//interfaz generica

public interface IServicioGenerico<E> {
	
public Iterable<E> findAll();
	
	public Optional<E> findById(Long id);
	
	public E save(E entidad);
	
	public void deleteById(Long id);

}
