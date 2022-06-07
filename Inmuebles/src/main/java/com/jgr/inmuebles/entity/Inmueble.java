package com.jgr.inmuebles.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Slf4j
@Entity
@Table(name = "inmuebles")
public class Inmueble {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "direccion")
	@NotEmpty
	private String direccion;
	
	@Column(name = "fechacomprainmueble")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date fechacomprainmueble;
		
	@Column(name = "importecomprainmueble")	
	@NotNull
	private double importecomprainmueble;
	
	//1inmueble-nanios
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "inmueble", fetch = FetchType.LAZY)
	private Set <AnioInmueble> anioinmueble;

	@ManyToMany
	@JoinTable(name = "rel_inmueble_detallemes", joinColumns = @JoinColumn(name = "inmueble_id"), inverseJoinColumns = @JoinColumn(name = "detallemesinmueble_id"))
	private Set<DetalleMesInmueble> inmuebledetallemes;
	
	
	
}
