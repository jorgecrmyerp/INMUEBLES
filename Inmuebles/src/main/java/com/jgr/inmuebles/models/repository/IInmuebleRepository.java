package com.jgr.inmuebles.models.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.jgr.inmuebles.models.entity.Inmueble;


@Repository
public interface IInmuebleRepository extends JpaRepository<Inmueble,Long>{


	

}
