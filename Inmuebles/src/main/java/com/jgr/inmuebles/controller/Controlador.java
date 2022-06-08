package com.jgr.inmuebles.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jgr.inmuebles.models.entity.AnioInmueble;
import com.jgr.inmuebles.models.entity.DetalleMesInmueble;
import com.jgr.inmuebles.models.entity.Inmueble;
import com.jgr.inmuebles.models.service.IAnioInmuebleService;
import com.jgr.inmuebles.models.service.IDetalleMesInmuebleService;
import com.jgr.inmuebles.models.service.IinmuebleService;

@Controller
public class Controlador {
	
	

	@Autowired
	private IAnioInmuebleService anioInmuebleService;
	
	@Autowired
	private IDetalleMesInmuebleService detalleMesInmuebleService;
	
	@Autowired
	private IinmuebleService inmuebleService;
	
	@PostConstruct
		public void cargaInicial() {
			
			Inmueble casa = new Inmueble();
			java.util.Date dt = new java.util.Date();
			
			casa.setFechacomprainmueble(dt);
			casa.setDireccion("direccioninmueble");
			casa.setImportecomprainmueble(150000.00);
			
			AnioInmueble aniocasa = new AnioInmueble();
			
			aniocasa.setAnio("2008");
			
			
			inmuebleService.save(casa);
			
			
			
		}
	

}
