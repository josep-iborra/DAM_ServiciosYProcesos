package es.florida.T4_eva;

import java.io.Serializable;

public class Contrasena implements Serializable {

	String textoPlano, encriptada;

	public Contrasena(String textoPlano, String encriptada) {

		this.textoPlano = textoPlano;
		this.encriptada = encriptada;
	}

	public Contrasena() {
		super();

	}

	/*
	 * Metode: geters Descripcio: Coge la contrasena texto plano y encriptado para mostrarlos 
	 * Parametres d'entrada: 
	 * Parametres d'exida: return
	 */

	public String getTextoPlano() {
		return textoPlano;
	}

	public String getEncriptada() {
		return encriptada;
	}

	/*
	 * Metode: seters Descripcio: Modifica la contrasena texto plano a la encriptado para poder mostrarlo 
	 * Parametres d'entrada: 
	 * Parametres d'exida: return
	 */

	public void setTextoPlano(String textoPlano) {
		this.textoPlano = textoPlano;
	}

	public void setEncriptada(String encriptada) {
		this.encriptada = encriptada;
	}

}
