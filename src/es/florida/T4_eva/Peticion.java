package es.florida.T4_eva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Peticion implements Runnable {
	BufferedReader bfr;
	PrintWriter pw;
	Socket socket;

	public Peticion(Socket socket) {
		this.socket = socket;
	}
	/* Metode: Cifrar 
	*Descripcio: Coge la contrasena y la cifra en ASCII con una posición mas.
	*Parametres d'entrada: contrasena
	*Parametres d'exida: return String.valueOf(array); ( la contraseña con un caracter mas).
	*/
	public String CifrarASCII(String pw) {
		char array[] = pw.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i] <= 31 && array[i] == 127) {
				array[i] += '*';
			} else {
				array[i] = (char) (array[i] + (char) 1);
			}
		}
		return String.valueOf(array);
	}
	
	/* Metode: CifrarMD5 
	*Descripcio: Coge la contrasena y la cifra en MD5 
	*Parametres d'entrada: contrasena
	*Parametres d'exida: return hashtext
	*/

	public static String CifrarMD5(String pw) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(pw.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	/* Metode: run 
	*Descripcio: Ejecuta el servidor
	*Parametres d'entrada: no
	*Parametres d'exida: no
	*/

	public void run() {
		try {
			//Creamos el objeto Contrasena y se envía al cliente
			System.err.println("SERVIDOR >>> Creamos el objeto contraseña y lo envíamos al cliente");
			ObjectOutputStream outObjeto = new ObjectOutputStream(socket.getOutputStream());
			Contrasena c = new Contrasena();
			outObjeto.writeObject(c);

			// Recibimos la contraseña que ha puesto el cliente
			ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());
			Contrasena pMod = (Contrasena) inObjeto.readObject();
			System.err.println("SERVIDOR >>> Contraseña del cliente: " + pMod.getTextoPlano());

			// Preguntamos el tipo de encriptación
			System.err.println("SERVIDOR >>> Pregunta el tipo de encriptación");
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			bfr = new BufferedReader(isr);
			OutputStream os = socket.getOutputStream();

			pw = new PrintWriter(os);
			int opcionMetodo = Integer.parseInt(bfr.readLine());
			System.err.println("SERVIDOR >>> Recibimos la opción para encriptar la contraseña");
			System.err.println("SERVIDOR >>> Realizamos la encriptación");
			String contrasena = pMod.getTextoPlano();
			String contrasenaCifrada = "";
			if (opcionMetodo == 2) {
				contrasenaCifrada = CifrarMD5(contrasena);
			} else {
				contrasenaCifrada = CifrarASCII(contrasena);
			}

			System.err.println("SERVIDOR >>> Devolvemos la contraseña encriptada: " + contrasenaCifrada);
			pw.write(contrasenaCifrada.toString() + "\n");

			c = new Contrasena(contrasena, contrasenaCifrada);
			System.err.println("SERVIDOR >>> Enviamos al cliente: " + contrasenaCifrada);
			outObjeto.writeObject(c);

			pw.flush();
			outObjeto.close();
			inObjeto.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("SERVIDOR >>> Error");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
