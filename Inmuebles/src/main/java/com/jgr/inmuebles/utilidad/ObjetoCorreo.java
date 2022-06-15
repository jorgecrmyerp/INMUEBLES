package com.jgr.inmuebles.utilidad;

import java.io.Serializable;

public class ObjetoCorreo implements Serializable{

    
    /**
     * nombre del fichero
     */
    private String nombre;
    /**
     * tipo de  fichero
     */
    private String tipo;
    /**
     * tamanio de  fichero
     */
    private Long tamanio;
    /**
     * datos del  fichero
     */
    private byte[] fichero;
   
    
    public ObjetoCorreo() {}
    
    
    public ObjetoCorreo(ObjetoCorreo objeto) {
	this.nombre=objeto.nombre;
	this.tipo=objeto.tipo;
	this.tamanio=objeto.tamanio;
	this.fichero=objeto.fichero;
	
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return this.nombre;
    }


    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * @return the tipo
     */
    public String getTipo() {
        return this.tipo;
    }


    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    /**
     * @return the tamanio
     */
    public Long getTamanio() {
        return this.tamanio;
    }


    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(Long tamanio) {
        this.tamanio = tamanio;
    }


    /**
     * @return the fichero
     */
    public byte[] getFichero() {
        return this.fichero;
    }


    /**
     * @param fichero the fichero to set
     */
    public void setFichero(byte[] fichero) {
        this.fichero = fichero;
    }


    
    
    
}

