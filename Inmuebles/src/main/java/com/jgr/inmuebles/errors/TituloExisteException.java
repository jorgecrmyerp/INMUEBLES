package com.jgr.inmuebles.errors;

public class TituloExisteException extends RuntimeException {
	
	private static final long serialVersionUID = -7422416401730360988L;

	public TituloExisteException(String id) {
		super("Pelicula: ".concat(id).concat(" ya existe en el sistema"));
	}

}