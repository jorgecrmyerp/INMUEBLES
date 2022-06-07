package com.jgr.inmuebles.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Slf4j

@Entity
@Table(name = "anioinmuebles")
public class AnioInmueble {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "anio")
	@NotEmpty
	private String anio;
	
	@Column(name = "mes")
	@NotEmpty
	private String mes;
	
	@Column(name = "importeSeguroVivienda")
	@NotNull
	private double importeSeguroVivienda;
	
	@Column(name = "importeSeguroImpago")
	@NotNull	
	private double importeSeguroImpago;
	
	@Lob
	@Column(name = "docSeguroVivienda")
	private String docSeguroVivienda;
	
	@Lob
	@Column(name = "docSeguroImpago")
	private String docSeguroImpago;
	
	
	@Column(name = "datosAdicionales")
	@NotEmpty	
	private String datosAdicionales;
	
	@Lob
	@Column(name = "docdatosAdicionales")
	private String docdatosAdicionales;
	
	@Column(name = "num_meses")
	@NotEmpty	
	private int num_meses;
	
	
	//relacion con inmueble
	@ManyToOne(fetch = FetchType.EAGER)
	private Inmueble inmueble;
	
	//relacion con detallemes
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "anioinmueble", fetch = FetchType.LAZY)
	private Set <DetalleMesInmueble> detallemesinmueble;
	
	
	


	
}
