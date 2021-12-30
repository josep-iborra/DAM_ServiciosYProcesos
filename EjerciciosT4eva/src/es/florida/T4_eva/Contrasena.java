package es.florida.T4_eva;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Contrasena implements Serializable {
	
	String textoPlano;
	String encriptada;
	
	

	
	public Contrasena(String textoPlano, String encriptada) {

		this.textoPlano = textoPlano;
		this.encriptada = encriptada;
	}
	public Contrasena() {
		super();
	
	}
	/* Metode: geters 
	*Descripcio: Coge la contrasena texto plano y encriptado para mostrarlos
	*Parametres d'entrada: 
	*Parametres d'exida: return
	*/
	
	/* Metode: seters 
	*Descripcio: Modifica la contrasena texto plano a la encriptado para poder mostrarlo
	*Parametres d'entrada: 
	*Parametres d'exida: return
	*/
	public String getTextoPlano() {
		return textoPlano;
	}
	public void setTextoPlano(String textoPlano) {
		this.textoPlano = textoPlano;
	}
	public String getEncriptada() {
		return encriptada;
	}
	public void setEncriptada(String encriptada) {
		this.encriptada = encriptada;
	}
	
}
