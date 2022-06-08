package com.jgr.inmuebles.models.service;

import java.util.Optional;

import com.jgr.inmuebles.models.entity.DetalleMesInmueble;

public interface IDetalleMesInmuebleService {

	//como iterables es una interfaz es mas generico
	public Iterable<DetalleMesInmueble> findAll();	
	
	public Optional<DetalleMesInmueble> findById(Long id);

	public DetalleMesInmueble save(DetalleMesInmueble detalleMesInmueble);
	
	public void deleteById(Long id);

}
