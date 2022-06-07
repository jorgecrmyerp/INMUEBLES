package com.jgr.inmuebles.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Slf4j

@Entity
@Table(name = "detallemesinmueble")
public class DetalleMesInmueble {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@Column(name = "mes")
	private String mes;
	
	@Column(name = "importeAlquiler")
	@NotNull
	private double importeAlquiler;
	
	
	@Column(name = "importeComunidad")
	@NotNull
	private double importeComunidad;
	
	@Lob
	@Column(name = "docimporteComunidad")
	private String docimporteComunidad;
		
	
	@Column(name = "importeIbi")
	@NotNull
	private double importeIbi;
	
	@Lob
	@Column(name = "docimporteIbi")
	private String docimporteIbi;
		
		
	@Column(name = "gastosAdicionales")
	@NotNull	
	private double gastosAdicionales;
	
	@Column(name = "detallegastosadicionales")
	private String detallegastosadicionales;
	
	@Lob
	@Column(name = "docgastosadicionales")
	private String docgastosadicionales;
	
	
	//relacion con anioinmueble
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "anioinmueble_id")
	private AnioInmueble anioinmueble;
	
	
	//relacion con inmueble
	@ManyToMany(mappedBy = "inmuebledetallemes")
	private Set<Inmueble> inmuebles;
	
	

}
