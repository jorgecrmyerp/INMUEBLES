package com.jgr.inmuebles.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jgr.inmuebles.models.entity.AnioInmueble;
import com.jgr.inmuebles.models.entity.DetalleMesInmueble;
import com.jgr.inmuebles.models.entity.Inmueble;
import com.jgr.inmuebles.models.service.IinmuebleService;
import com.jgr.inmuebles.util.PageRender;

@Controller
@SessionAttributes("inmueble")
public class InmueblesController {

	@Autowired
	private IinmuebleService inmuebleService;

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
	
	

	@GetMapping(value = { "/listarinmuebles","/" })
	public String listaInmuebles(@RequestParam(name = "page", defaultValue = "0") int page, Model modelo) {
		Inmueble inmueble = new Inmueble();
		Pageable pageRequest = PageRequest.of(page, 4);
		Page<Inmueble> inmuebles = inmuebleService.findAllPeliculas(pageRequest);
		inmuebles.forEach(System.out::println);
		PageRender<Inmueble> pageRender = new PageRender<Inmueble>("/listarinmuebles", inmuebles);
		modelo.addAttribute("inmuebles", inmueble);
		modelo.addAttribute("listaInmuebles", inmuebles);
		modelo.addAttribute("page", pageRender);
		return "inmuebles/inmuebleslista";
	}

	
	
}
