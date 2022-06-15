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
