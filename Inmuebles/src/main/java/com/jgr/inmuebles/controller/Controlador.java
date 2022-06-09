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
	private IinmuebleService inmuebleService;

	@Autowired
	private IAnioInmuebleService anioInmuebleService;

	@Autowired
	private IDetalleMesInmuebleService detalleMesInmuebleService;



	@PostConstruct
	public void cargaInicial1() {

		Inmueble casa = new Inmueble();
		AnioInmueble aniocasa = new AnioInmueble();
		DetalleMesInmueble detallecasa = new DetalleMesInmueble();
		/*
		java.util.Date dt = new java.util.Date();

		casa.setFechacomprainmueble(dt);
		casa.setDireccion("direccioninmueble");
		casa.setImportecomprainmueble(150000.00);	
		casa=inmuebleService.save(casa);


		aniocasa = new AnioInmueble();
		aniocasa.setAnio("2008");
		aniocasa.setDatosAdicionales("datosadicionales");
		aniocasa.setDocdatosAdicionales("doc");
		aniocasa.setDocSeguroImpago("doc");
		aniocasa.setDocSeguroVivienda("doc");
		aniocasa.setImporteSeguroImpago(1.0);
		aniocasa.setImporteSeguroVivienda(1.1);
		aniocasa.setMes("01");
		aniocasa.setNum_meses(12);
		aniocasa.setInmueble(casa);	



		//anioInmuebleService.save(aniocasa);


		detallecasa = new DetalleMesInmueble();
		detallecasa.setAnioinmueble(aniocasa);
		detallecasa.setDetallegastosadicionales("detalle");
		detallecasa.setDocgastosadicionales("doc");
		detallecasa.setDocimporteComunidad("doc");
		detallecasa.setDocimporteComunidad("doc");
		detallecasa.setDocimporteIbi("doc");
		detallecasa.setGastosAdicionales(0);
		detallecasa.setImporteAlquiler(0);
		detallecasa.setImporteComunidad(0);
		detallecasa.setMes("01");
		detallecasa.setAnioinmueble(aniocasa);
		detallecasa.setInmueble(casa);

		detalleMesInmuebleService.save(detallecasa);

		
			detallecasa = new DetalleMesInmueble();
			detallecasa.setAnioinmueble(aniocasa);
			detallecasa.setDetallegastosadicionales("detalle");
			detallecasa.setDocgastosadicionales("doc");
			detallecasa.setDocimporteComunidad("doc");
			detallecasa.setDocimporteComunidad("doc");
			detallecasa.setDocimporteIbi("doc");
			detallecasa.setGastosAdicionales(0);
			detallecasa.setImporteAlquiler(0);
			detallecasa.setImporteComunidad(0);
			detallecasa.setMes("02");
			//detallecasa.setAnioinmueble(aniocasa);

			detalleMesInmuebleService.save(detallecasa);

		
*/
		
			System.out.println(inmuebleService.findById((long) 1).toString());

			inmuebleService.findById((long) 1).getAnioinmueble();
			
			for(AnioInmueble anio:inmuebleService.findById((long) 1).getAnioinmueble()) {
				
				System.out.println("anio->" +anio.getAnio());
				
				for(DetalleMesInmueble detalle:anio.getDetallemesinmueble()) {
					
				System.out.println("mes->"+detalle.getMes());
					
				}
				
			}
			
			System.out.println("Busco por detalle inmueble");
			
			for(DetalleMesInmueble detalle:inmuebleService.findById((long) 1).getInmuebledetallemes()) {
				
				
				System.out.println("mes->"+detalle.getMes());
				System.out.println("inmueble->"+detalle.getInmueble());
				System.out.println("anio->"+detalle.getAnioinmueble().getAnio());
				
				 
			}
			
			
	}
	

	


}
