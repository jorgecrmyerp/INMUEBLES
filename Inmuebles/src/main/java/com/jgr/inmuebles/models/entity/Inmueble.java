package com.jgr.inmuebles.models.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name = "inmuebles")
public class Inmueble {
	//@Transient
	//private static final Logger LOGGER = LoggerFactory.getLogger(Inmueble.class);
	
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
	private Set <AnioInmueble> anioInmueble;

	
	@OneToMany(mappedBy="inmueble",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	private Set<DetalleMesInmueble> inmuebleDetalleMes;

	public Inmueble() {
		anioInmueble = new HashSet<>();
		inmuebleDetalleMes = new HashSet<>();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Date getFechacomprainmueble() {
		return fechacomprainmueble;
	}


	public void setFechacomprainmueble(Date fechacomprainmueble) {
		this.fechacomprainmueble = fechacomprainmueble;
	}


	public double getImportecomprainmueble() {
		return importecomprainmueble;
	}


	public void setImportecomprainmueble(double importecomprainmueble) {
		this.importecomprainmueble = importecomprainmueble;
	}


	public Set<AnioInmueble> getAnioinmueble() {
		return anioInmueble;
	}


	public void setAnioinmueble(Set<AnioInmueble> anioinmueble) {
		this.anioInmueble = anioinmueble;
	}
	
	public void setaddAnioinmueble(AnioInmueble anioinmueble) {
		this.anioInmueble.add(anioinmueble);
	}
	


	public Set<DetalleMesInmueble> getInmuebledetallemes() {
		return inmuebleDetalleMes;
	}
	
	
	public void setInmuebledetallemes(Set<DetalleMesInmueble> inmuebledetallemes) {
		this.inmuebleDetalleMes = inmuebledetallemes;
	}

	public void addInmuebledetallemes(DetalleMesInmueble inmuebledetallemes) {
		this.inmuebleDetalleMes.add(inmuebledetallemes);
	}


	@Override
	public String toString() {
		return "Inmueble [id=" + id + ", direccion=" + direccion + ", fechacomprainmueble=" + fechacomprainmueble
				+ ", importecomprainmueble=" + importecomprainmueble + "]";
	}


	
	

	
}
