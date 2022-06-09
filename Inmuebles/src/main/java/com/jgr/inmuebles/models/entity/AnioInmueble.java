package com.jgr.inmuebles.models.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;




@Entity
@Table(name = "anioinmuebles")
public class AnioInmueble {
	
	//@Transient
	//private static final Logger LOGGER = LoggerFactory.getLogger(AnioInmueble.class);
		
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
	@NotNull	
	private int num_meses;
	
	
	//relacion con inmueble
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="inmueble_id")
	private Inmueble inmueble;
	
	//relacion con detallemes
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "anioinmueble", fetch = FetchType.EAGER)
	private Set <DetalleMesInmueble> detallemesinmueble;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public double getImporteSeguroVivienda() {
		return importeSeguroVivienda;
	}

	public void setImporteSeguroVivienda(double importeSeguroVivienda) {
		this.importeSeguroVivienda = importeSeguroVivienda;
	}

	public double getImporteSeguroImpago() {
		return importeSeguroImpago;
	}

	public void setImporteSeguroImpago(double importeSeguroImpago) {
		this.importeSeguroImpago = importeSeguroImpago;
	}

	public String getDocSeguroVivienda() {
		return docSeguroVivienda;
	}

	public void setDocSeguroVivienda(String docSeguroVivienda) {
		this.docSeguroVivienda = docSeguroVivienda;
	}

	public String getDocSeguroImpago() {
		return docSeguroImpago;
	}

	public void setDocSeguroImpago(String docSeguroImpago) {
		this.docSeguroImpago = docSeguroImpago;
	}

	public String getDatosAdicionales() {
		return datosAdicionales;
	}

	public void setDatosAdicionales(String datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}

	public String getDocdatosAdicionales() {
		return docdatosAdicionales;
	}

	public void setDocdatosAdicionales(String docdatosAdicionales) {
		this.docdatosAdicionales = docdatosAdicionales;
	}

	public int getNum_meses() {
		return num_meses;
	}

	public void setNum_meses(int num_meses) {
		this.num_meses = num_meses;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public Set<DetalleMesInmueble> getDetallemesinmueble() {
		return detallemesinmueble;
	}

	public void setDetallemesinmueble(Set<DetalleMesInmueble> detallemesinmueble) {
		this.detallemesinmueble = detallemesinmueble;
	}

	@Override
	public String toString() {
		return "AnioInmueble [id=" + id + ", anio=" + anio + ", mes=" + mes + ", importeSeguroVivienda="
				+ importeSeguroVivienda + ", importeSeguroImpago=" + importeSeguroImpago + ", docSeguroVivienda="
				+ docSeguroVivienda + ", docSeguroImpago=" + docSeguroImpago + ", datosAdicionales=" + datosAdicionales
				+ ", docdatosAdicionales=" + docdatosAdicionales + ", num_meses=" + num_meses + "]";
	}

	
	
	
	
}
