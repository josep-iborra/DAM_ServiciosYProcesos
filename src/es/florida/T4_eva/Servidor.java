package es.florida.T4_eva;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {
	/* Metode: main
	*Descripcio: Ejecuta la aplicación de la parte servidor
	*Parametres d'entrada:String []
	*Parametres d'exida: no
	*/

	public static void main(String[] args) throws IOException {
		System.err.println("SERVIDOR >>> Arrancamos el servidor, esperamos la peticion");
		ServerSocket socketEscucha = null;
		try {
			socketEscucha = new ServerSocket(7777);
		} catch (IOException e) {
			System.err.println("SERVIDOR >>> Error");
			return;
		}
		while (true) {
			Socket conexion = socketEscucha.accept();
			System.err.println("SERVIDOR >>> Conexion recibida");
			Peticion p = new Peticion(conexion);
			Thread hilo = new Thread(p);
			hilo.start();
		}
	}
}
