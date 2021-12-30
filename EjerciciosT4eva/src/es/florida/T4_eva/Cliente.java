package es.florida.T4_eva;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
	
public class Cliente {
		
	/* Metode: main
	*Descripcio: Ejecuta la aplicación de la parte cliente
	*Parametres d'entrada:String
	*Parametres d'exida: no
	*/

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		String host = "localhost";
		int puerto = 7777;
		System.out.println("CLIENTE >> Arranca cliente");
		Socket cliente = new Socket(host, puerto);
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		Contrasena c = (Contrasena) inObjeto.readObject();
		Scanner sc = new Scanner(System.in);
		System.out.print("CLIENTE >> Introduce una contraseña: ");
		String contrasenaTeclado = sc.nextLine();
		c.setTextoPlano(contrasenaTeclado);
		ObjectOutputStream pMod = new ObjectOutputStream(cliente.getOutputStream());
		pMod.writeObject(c);
		System.out.println("CLIENTE >> Envio al servidor para encriptar la contraseña: " + c.getTextoPlano());
		PrintWriter pw = new PrintWriter(cliente.getOutputStream());
		System.out.print("CLIENTE >> Métodos de encriptación: \n" 
		+"- 1. ASCII \n" 
		+ "- 2. MD5 \n"
		+ "Introduce un método de encriptación: ");
		String opcion = sc.nextLine();
		switch (opcion) {
		case "1":
			System.out.println("CLIENTE >> El método de encriptación elegido es: ASCII");
			break;
		case "2":
			System.out.println("CLIENTE >> El método de encriptación elegido es: MD5");
			break;
		}
		pw.print(opcion + "\n");
		pw.flush();

		c = (Contrasena) inObjeto.readObject();
		System.out.println("CLIENTE >> Contraseña encriptada recibida del servidor: " + c.getEncriptada());

		sc.close();
		inObjeto.close();
		pMod.close();
		cliente.close();

	}

}