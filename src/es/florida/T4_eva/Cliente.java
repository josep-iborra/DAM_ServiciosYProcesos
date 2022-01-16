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
	*Parametres d'entrada:String[]
	*Parametres d'exida: no
	*/
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
	
		System.out.println("CLIENTE >> Arranca cliente");
		Socket cliente = new Socket("localhost", 7777);
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		Contrasena c = (Contrasena) inObjeto.readObject();
		Scanner sc = new Scanner(System.in);
		System.out.print("CLIENTE >> Introduce una contraseña: ");
		String password = sc.nextLine();
		c.setTextoPlano(password);
		ObjectOutputStream pMod = new ObjectOutputStream(cliente.getOutputStream());
		pMod.writeObject(c);
		System.out.println("CLIENTE >> Se ha enviado al servidor para encriptar la contraseña: " + c.getTextoPlano());
		PrintWriter pw = new PrintWriter(cliente.getOutputStream());
		System.out.print("CLIENTE >> Que metodo de encriptación quieres?: \n" 
		+"- 1. ASCII \n" 
		+ "- 2. MD5 \n");
		String opcion = sc.nextLine();
		pw.print(opcion + "\n");
		pw.flush();

		c = (Contrasena) inObjeto.readObject();
		System.out.println("CLIENTE >> Contraseña encriptada: " + c.getEncriptada());

		sc.close();
		inObjeto.close();
		pMod.close();
		cliente.close();

	}

}