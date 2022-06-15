package com.jgr.inmuebles.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
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

import com.jgr.inmuebles.errors.ErrorBBDDException;
import com.jgr.inmuebles.errors.IdNoEncontradoException;
import com.jgr.inmuebles.models.entity.AnioInmueble;
import com.jgr.inmuebles.models.entity.DetalleMesInmueble;
import com.jgr.inmuebles.models.entity.Inmueble;
import com.jgr.inmuebles.models.service.IAnioInmuebleService;
import com.jgr.inmuebles.models.service.IDetalleMesInmuebleService;
import com.jgr.inmuebles.models.service.IinmuebleService;
import com.jgr.inmuebles.utilidad.PageRender;

@Controller
@SessionAttributes("inmueble")
public class InmueblesController {

	@Autowired
	private IinmuebleService inmuebleService;

	@Autowired
	private IAnioInmuebleService anioService;

	@Autowired
	private IDetalleMesInmuebleService detalleService;

	//@PostConstruct()
	public void insertarDatos() {

		Inmueble casa;
		AnioInmueble anio;
		DetalleMesInmueble detalle;

		for (int a = 0; a < 2; a++) {
			casa = new Inmueble();
			casa.setFechacomprainmueble(new Date());
			casa.setDireccion("direccion casa " + a);
			casa.setImportecomprainmueble((1.00) * a + 1);
			casa.setDatosAdicionales("DatosAdicionales" + a);
			casa.setDocdatosAdicionales("DocDatosAdicionales" + a);

			for (int i = 0; i < 2; i++) {

				anio = new AnioInmueble();
				anio.setAnio("Anio" + i);
				anio.setContrato("Contrato" + i);
				anio.setDatosAdicionales("DatosAdicionales" + i);
				anio.setDocdatosAdicionales("DocdatosAdicionales" + i);
				anio.setDocSeguroImpago("DocSeguroImpago" + i);
				anio.setDocSeguroVivienda("DocSeguroVivienda" + i);
				anio.setImporteSeguroImpago(i + 1);
				anio.setImporteSeguroVivienda(i + 1 + 1);
				anio.setNum_meses(i + 1);
				anio.setInmueble(casa);

				for (int j = 1; j < 13; j++) {
					detalle = new DetalleMesInmueble();
					detalle.setAnioinmueble(anio);
					detalle.setMes("mes" + j);
					detalle.setDetallegastosadicionales("Detallegastosadicionales" + j);
					detalle.setDocgastosadicionales("Docgastosadicionales" + j);
					detalle.setDocimporteComunidad("DocimporteComunidad" + j);
					detalle.setDocimporteIbi("DocimporteIbi" + j);
					detalle.setGastosAdicionales(j);
					detalle.setImporteAlquiler(j);
					detalle.setImporteComunidad(j);
					detalle.setImporteIbi(j);
					detalle.setInmueble(casa);
					anio.addDetallemesinmueble(detalle);
				}

				casa.addAnio(anio);

			}
			inmuebleService.save(casa);
		}

	}

	@GetMapping(value = { "/listarinmuebles", "/" })
	public String listaInmuebles(@RequestParam(name = "page", defaultValue = "0") int page, Model modelo) {
		Inmueble inmueble = new Inmueble();
		Pageable pageRequest = PageRequest.of(page, 4);
		Page<Inmueble> inmuebles = inmuebleService.findAllInmuebles(pageRequest);
		inmuebles.forEach(System.out::println);
		PageRender<Inmueble> pageRender = new PageRender<Inmueble>("/listarinmuebles", inmuebles);
		modelo.addAttribute("inmuebles", inmueble);
		modelo.addAttribute("listaInmuebles", inmuebles);
		modelo.addAttribute("page", pageRender);
		return "inmuebles/inmuebleslista";
	}

	@GetMapping(value = { "/prevModif/{id}" })
	public String prevModifPelicula(@PathVariable int id, Model modelo, RedirectAttributes redirectAttrs) {
		// modelo.addAttribute("listaGeneros", listaGeneros());

		// esto no deberia darse nunca,pero....
		try {

			Optional<Inmueble> casa = inmuebleService.findById(Long.valueOf(id));
			
			if (!casa.isPresent()) {
				throw new IdNoEncontradoException(String.valueOf(id));
			}
			modelo.addAttribute("inmueble",casa.get());

		} catch (DataAccessException e) {
			throw new ErrorBBDDException(e.getClass().toString().concat(e.getMessage()));
		}
		
		return "inmuebles/modInmueble";
	}

}
