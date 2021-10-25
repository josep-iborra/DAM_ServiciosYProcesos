package es.florida.T2eva;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AE2 {
	/* Metode: lanzarCalculador
		*Descripcio: añadix les variables calculades
		*Parametres d'entrada:	nombreNEO, velocidad, posicion
		*Parametres d'exida: 
	*/
	public void lanzarCalculador(String nombreNEO, String velocidad, String posicion) {
		String clase = "es.florida.T2eva.Calculador";
		try {

			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			// System.out.println(classpath);
			String className = clase;

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(nombreNEO.toString()); //introduix el nomb
			command.add(velocidad.toString()); //introduix la velocitat
			command.add(posicion.toString()); //introduix la posicio

			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.inheritIO().start();
			//Process process = builder.start();
			process.waitFor(); // espera que termine un proceso para empezar otro

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* Metode: contenidoFichero
		*Descripcio: llig el fitxer
		*Parametres d'entrada:
		*Parametres d'exida: contenidoFichero;
	*/
	public ArrayList<String> contenidoFichero() {
		ArrayList<String> contenidoFichero = new ArrayList<String>();
		File f = new File("NEOs.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				contenidoFichero.add(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		return contenidoFichero;
	}
	/* Metode: main
		*Descripcio: agarra linea per linea del fitxer i tambe calcula els mistge per el numero de cores que tingues.
		*			 Tambe trau el temps que dura la aplicacio i tambe la mitja de cada proces.
		*Parametres d'entrada:
		*Parametres d'exida: contenidoFichero;
	*/
	public static void main(String[] args) {
		long startTime = System.nanoTime(); // agarra el temps cuant comenaça la aplicacio.
		
		
		String archivo= "NEOs.txt";
		ArrayList<String> fichero = new ArrayList<String>();
		
		AE2 a = new AE2();
		fichero = a.contenidoFichero();
		//conta el nuclis que tens
		int nucleos = Runtime.getRuntime().availableProcessors();
		
		for(int i=0; i<nucleos; i++) {
			String [] lineas=fichero.get(i).split(","); 
				
				a.lanzarCalculador(lineas[0], lineas[1], lineas[2]);
		}
		
		long endTime = System.nanoTime();  //agarra el temps final del que ha durat la aplicacio
		
		// calcul de temps total que ha durat la aplicacio
		long miliTiempo =(long) ((endTime-startTime)/1e6);
		double tiempo = (miliTiempo/1000);
		String segundos = String.format("%.2f", tiempo);
	        System.out.println(segundos +" segundos");
	    
	    // calcul de la mitjana del temps que a durat per cada nucli
	    double mediaTiempo = ( tiempo / nucleos);
	    String media = String.format("%.2f", mediaTiempo);
	    System.out.println("El tiempo medio es: "+media);
		
	}

}
