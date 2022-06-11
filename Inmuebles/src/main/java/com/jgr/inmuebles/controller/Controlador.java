package com.jgr.inmuebles.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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

	// @PostConstruct
	public void cargaInicial1() {

		Inmueble casa = new Inmueble();
		AnioInmueble aniocasa = new AnioInmueble();
		DetalleMesInmueble detallecasa = new DetalleMesInmueble();

		List<Inmueble> inmuebles = new ArrayList<Inmueble>();
		List<AnioInmueble> anios = new ArrayList<AnioInmueble>();
		List<DetalleMesInmueble> detalles = new ArrayList<DetalleMesInmueble>();

		java.util.Date dt = new java.util.Date();

		casa.setDireccion("direccion");
		casa.setFechacomprainmueble(dt);
		casa.setImportecomprainmueble(1000);

		// inmuebleService.save(casa);

		// if(inmuebleService.findById(casa.getId())!=null) {
		aniocasa = new AnioInmueble();
		int anio = 2007;
		for (int i = 0; i < 2; i++) {
			aniocasa.setAnio(String.valueOf(anio + i));
			aniocasa.setDocdatosAdicionales("DocdatosAdicionales" + i);
			aniocasa.setDocSeguroImpago("setDocSeguroImpago" + i);
			aniocasa.setDocSeguroVivienda("setDocSeguroVivienda" + i);
			aniocasa.setImporteSeguroImpago(i);
			aniocasa.setImporteSeguroVivienda(i);
			aniocasa.setMes("MES" + i);
			aniocasa.setNum_meses(i);
			aniocasa.setInmueble(casa);

			for (int j = 0; j < 2; j++) {
				detallecasa = new DetalleMesInmueble();
				detallecasa.setAnioinmueble(aniocasa);
				detallecasa.setMes("mes" + j);
				detallecasa.setDetallegastosadicionales("setDetallegastosadicionales" + i);
				detallecasa.setDocgastosadicionales("setDocgastosadicionales" + i);
				detallecasa.setDocimporteComunidad("setDocimporteComunidad" + i);
				detallecasa.setDocimporteIbi("setDocimporteIbi" + i);
				detallecasa.setImporteAlquiler(i + j * 2);
				detallecasa.setImporteComunidad(i + j * 3);
				detallecasa.setImporteIbi(i + j * 4);
				detallecasa.setInmueble(casa);
				detalles.add(detallecasa);

				// detalleMesInmuebleService.save(detallecasa);

			}

			aniocasa.setaddDetallemesinmueble(detallecasa);

			anios.add(aniocasa);

			// anioInmuebleService.save(aniocasa);

			// }

		}
		Set<AnioInmueble> aniosSet = new HashSet<AnioInmueble>(anios);

		Set<DetalleMesInmueble> detallesSet = new HashSet<DetalleMesInmueble>(detalles);

		casa.setAnioinmueble(aniosSet);
		casa.setInmuebledetallemes(detallesSet);

		inmuebleService.save(casa);

	}

	@PostConstruct
	public void verDatos1() {

		for (Inmueble casa : inmuebleService.findAll()) {

			System.out.println("casa->" + casa.getDireccion());

			for (AnioInmueble anio : casa.getAnioinmueble()) {

				System.out.println("anio->" + anio.getAnio());

				for (DetalleMesInmueble detalle : anio.getDetallemesinmueble()) {

					System.out.println("detalle->" + detalle.getMes());
					System.out.println("detalle->" + detalle.getInmueble());

				}

			}

			for (DetalleMesInmueble detalle : casa.getInmuebledetallemes()) {

				System.out.println("DetalleCasa->" + detalle.getInmueble().getDireccion());

				for (AnioInmueble anio : detalle.getInmueble().getAnioinmueble()) {
					System.out.println("DetalleInmueble->" + anio.getAnio());

				}

			}

		}

	}

}
