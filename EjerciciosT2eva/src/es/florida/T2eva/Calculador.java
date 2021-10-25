package es.florida.T2eva;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Calculador {

	/*
	 * Metode: calculo 
	 	 * Descripcio: Fa els calculs necesaris per a medir elporcentaje.
		 * Parametres d'entrada: nombreNEO, posicioNEO, velocidadNEO
		 * Parametres d'exida: resultado.
	 */

	public static double calculo(String nombreNEO, double posicionNEO, double velocidadNEO) {

		String nombre = nombreNEO;
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
			posicionNEO = posicionNEO + velocidadNEO * i;
			posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random()
				* Math.pow(((posicionNEO - posicionTierra) / (posicionNEO + posicionTierra)), 2);

		return resultado;
	}
	/*
	 * Metode: Main 
	 	 *Descripcio: Comproba el resultat y depenent del resultat trau un misatge o altre 
		 * Parametres d'entrada: 
		 * Parametres d'exida:
	 */

	public static void main(String[] args) {
		Calculador s = new Calculador();
		String nombre = args[0];
		//String array [] = nombre.split(",");
		Double posicion = Double.parseDouble(args[1]);
		Double velocidad = Double.parseDouble(args[2]);

		double resultado = s.calculo(nombre, posicion, velocidad);
		if (resultado > 10) {

			System.err.println("Nos vamos a morir el porcentaje del asteroide " + nombre + " es: "
					+ String.format("%.2f", resultado) + "%" + "\n");

		} else {

			System.out.println("No ocurre nada posemos seguir viviendo el porcentaje del asteroide " + nombre + " es: "
					+ String.format("%.2f", resultado) + "%" + "\n");

		}
		//agafa el misatge y crea un archiu en el nom y dins escriu la probabilitat que te
		try {
			File fitxerNEO = new File(nombre + ".txt");
			FileWriter fw = new FileWriter(fitxerNEO);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Probilidad:" + String.format("%.2f", resultado) + "%");
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}