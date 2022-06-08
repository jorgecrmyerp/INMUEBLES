package com.jgr.inmuebles.models.service;

import java.util.Optional;

import com.jgr.inmuebles.models.entity.AnioInmueble;


public interface IAnioInmuebleService {
	
	//como iterables es una interfaz es mas generico
		public Iterable<AnioInmueble> findAll();	
		
		public Optional<AnioInmueble> findById(Long id);

		public AnioInmueble save(AnioInmueble anioInmueble);
		
		public void deleteById(Long id);


}
