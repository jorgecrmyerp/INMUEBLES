package com.jgr.inmuebles.models.service;

import java.util.Optional;

import com.jgr.inmuebles.models.entity.Inmueble;


public interface IinmuebleService {
	
	//como iterables es una interfaz es mas generico
	public Iterable<Inmueble> findAll();	
	
	public Optional<Inmueble> findById(Long id);

	public Inmueble save(Inmueble inmueble);
	
	public void deleteById(Long id);

}
