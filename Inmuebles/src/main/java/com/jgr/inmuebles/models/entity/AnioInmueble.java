package com.jgr.inmuebles.models.entity;

import java.util.HashMap;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "anioinmuebles")
public class AnioInmueble {

	// @Transient
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AnioInmueble.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "anio")
	// @NotEmpty
	private String anio;

	@Column(name = "contrato")
	@Lob
	//	@NotEmpty
	private String contrato;

	@Column(name = "importeSeguroVivienda")
	// @NotNull
	private double importeSeguroVivienda;

	@Column(name = "importeSeguroImpago")
	// @NotNull
	private double importeSeguroImpago;

	@Lob
	@Column(name = "docSeguroVivienda")
	private String docSeguroVivienda;

	@Lob
	@Column(name = "docSeguroImpago")
	private String docSeguroImpago;

	@Column(name = "datosAdicionales")
	// @NotEmpty
	private String datosAdicionales;

	@Lob
	@Column(name = "docdatosAdicionales")
	private String docdatosAdicionales;

	@Column(name = "num_meses")
	// @NotNull
	private int num_meses;

	// relacion con inmueble
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inmueble_id")
	@JsonManagedReference
	private Inmueble inmueble;

	// relacion con detallemes
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "anioinmueble", fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonBackReference
	private Set<DetalleMesInmueble> detallesmes;

	public AnioInmueble() {
		this.detallesmes = new HashSet<>();
	}

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

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
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
		return detallesmes;
	}

	public void setDetallemesinmueble(Set<DetalleMesInmueble> detallesmes) {
		/*
		 * //relacionamos detallemesinmueble con el año detallemesinmueble.forEach(d->{
		 * this.addDetallemesinmueble(d); });
		 */
		this.detallesmes.clear();
		detallesmes.forEach(this::addDetallemesinmueble);
		// this.detallemesinmueble = detallemesinmueble;
	}

	public void addDetallemesinmueble(DetalleMesInmueble detallemesinmueble) {
		detallemesinmueble.setAnioinmueble(this);
		this.detallesmes.add(detallemesinmueble);
	}

	public void removeDetallemesinmueble(DetalleMesInmueble detallemesinmueble) {
		this.detallesmes.remove(detallemesinmueble);

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AnioInmueble)) {
			return false;
		}
		AnioInmueble other = (AnioInmueble) obj;
		return this.id != null && this.id.equals(other.getId());
	}

}
