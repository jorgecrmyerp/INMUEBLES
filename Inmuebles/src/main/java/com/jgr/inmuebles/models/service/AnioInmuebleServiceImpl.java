package com.jgr.inmuebles.models.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgr.inmuebles.models.entity.AnioInmueble;
import com.jgr.inmuebles.models.repository.IAnioInmuebleRepository;

@Service //lo registro en el controlador de spring
public class AnioInmuebleServiceImpl implements IAnioInmuebleService {
	
	@Autowired
	private IAnioInmuebleRepository iAnioInmuebleRepository;

	@Override
	public Iterable<AnioInmueble> findAll() {
		return iAnioInmuebleRepository.findAll();
	}

	@Override
	public AnioInmueble findById(Long id) {
		return iAnioInmuebleRepository.findById(id).orElse(null);
	}

	@Override
	public AnioInmueble save(AnioInmueble anioInmueble) {
		return iAnioInmuebleRepository.save(anioInmueble);
	}

	@Override
	public void deleteById(Long id) {
		iAnioInmuebleRepository.deleteById(id);

	}

}
