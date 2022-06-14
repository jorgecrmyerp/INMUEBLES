package com.jgr.inmuebles.models.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jgr.inmuebles.models.entity.Inmueble;
import com.jgr.inmuebles.models.repository.IInmuebleRepository;

@Service //lo registro en el controlador de spring
public class InmuebleServiceImpl implements IinmuebleService{

	@Autowired
	private IInmuebleRepository inmueblesRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Inmueble> findAll() {
		return inmueblesRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Inmueble> findById(Long id) {
		return inmueblesRepository.findById(id);
	}

	@Override
	@Transactional
	public Inmueble save(Inmueble inmueble) {
		return inmueblesRepository.save(inmueble);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		inmueblesRepository.deleteById(id);
		
	}

	@Override
	public Page<Inmueble> findAllPeliculas(Pageable pageable) {
		return inmueblesRepository.findAll(pageable);
	}

}
