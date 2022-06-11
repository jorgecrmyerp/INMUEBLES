package com.jgr.inmuebles.models.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgr.inmuebles.models.entity.DetalleMesInmueble;
import com.jgr.inmuebles.models.repository.IDetalleMesInmuebleRepository;


@Service //lo registro en el controlador de spring
public class DetalleMesInmuebleImpl implements IDetalleMesInmuebleService {

	
	@Autowired
	private IDetalleMesInmuebleRepository detalleMesInmuebleRepository;
	
	@Override
	public Iterable<DetalleMesInmueble> findAll() {
		return detalleMesInmuebleRepository.findAll();
	}

	@Override
	public Optional<DetalleMesInmueble> findById(Long id) {
		return detalleMesInmuebleRepository.findById(id);
	}

	@Override
	public DetalleMesInmueble save(DetalleMesInmueble detalleMesInmueble) {
		return detalleMesInmuebleRepository.save(detalleMesInmueble);
	}

	@Override
	public void deleteById(Long id) {
		detalleMesInmuebleRepository.deleteById(id);

	}

}
