package com.jgr.inmuebles.models.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Entity
@Table(name = "detallemesinmueble")
public class DetalleMesInmueble {
	
	
	//@Transient
//	private static final Logger LOGGER = LoggerFactory.getLogger(DetalleMesInmueble.class);
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "mes")
	private String mes;
	
	@Column(name = "importeAlquiler")
	//@NotNull
	private double importeAlquiler;
	
	
	@Column(name = "importeComunidad")
	//@NotNull
	private double importeComunidad;
	
	@Lob
	@Column(name = "docimporteComunidad")
	private String docimporteComunidad;
		
	
	@Column(name = "importeIbi")
	//@NotNull
	private double importeIbi;
	
	@Lob
	@Column(name = "docimporteIbi")
	private String docimporteIbi;
		
		
	@Column(name = "gastosAdicionales")
	//@NotNull	
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
	@ManyToOne
	@JoinColumn(name="inmueble_id")
	private Inmueble inmueble;



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getMes() {
		return mes;
	}



	public void setMes(String mes) {
		this.mes = mes;
	}



	public double getImporteAlquiler() {
		return importeAlquiler;
	}



	public void setImporteAlquiler(double importeAlquiler) {
		this.importeAlquiler = importeAlquiler;
	}



	public double getImporteComunidad() {
		return importeComunidad;
	}



	public void setImporteComunidad(double importeComunidad) {
		this.importeComunidad = importeComunidad;
	}



	public String getDocimporteComunidad() {
		return docimporteComunidad;
	}



	public void setDocimporteComunidad(String docimporteComunidad) {
		this.docimporteComunidad = docimporteComunidad;
	}



	public double getImporteIbi() {
		return importeIbi;
	}



	public void setImporteIbi(double importeIbi) {
		this.importeIbi = importeIbi;
	}



	public String getDocimporteIbi() {
		return docimporteIbi;
	}



	public void setDocimporteIbi(String docimporteIbi) {
		this.docimporteIbi = docimporteIbi;
	}



	public double getGastosAdicionales() {
		return gastosAdicionales;
	}



	public void setGastosAdicionales(double gastosAdicionales) {
		this.gastosAdicionales = gastosAdicionales;
	}



	public String getDetallegastosadicionales() {
		return detallegastosadicionales;
	}



	public void setDetallegastosadicionales(String detallegastosadicionales) {
		this.detallegastosadicionales = detallegastosadicionales;
	}



	public String getDocgastosadicionales() {
		return docgastosadicionales;
	}



	public void setDocgastosadicionales(String docgastosadicionales) {
		this.docgastosadicionales = docgastosadicionales;
	}



	public AnioInmueble getAnioinmueble() {
		return anioinmueble;
	}



	public void setAnioinmueble(AnioInmueble anioinmueble) {
		this.anioinmueble = anioinmueble;
	}



	public Inmueble getInmueble() {
		return inmueble;
	}



	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}



	@Override
	public String toString() {
		return "DetalleMesInmueble [id=" + id + ", mes=" + mes + ", importeAlquiler=" + importeAlquiler
				+ ", importeComunidad=" + importeComunidad + ", docimporteComunidad=" + docimporteComunidad
				+ ", importeIbi=" + importeIbi + ", docimporteIbi=" + docimporteIbi + ", gastosAdicionales="
				+ gastosAdicionales + ", detallegastosadicionales=" + detallegastosadicionales
				+ ", docgastosadicionales=" + docgastosadicionales + "]";
	}



	
	

}
