package es.florida.noEva1;
import java.util.Scanner;
import java.util.*;

public class Ej22 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		String nombrePersona;
		boolean pasar;
		
		do {
		System.out.print("Por favor introduzca un nombre: ");
		nombrePersona = sc.nextLine();
		
			if(isNumeric(nombrePersona)) {
				 pasar = false;
			}else {
				pasar = true;
			}
		}while (pasar);
		
		
		sc.close();
		
   }
	private static boolean isNumeric(String nombrePersona){

		try {
			int numeroPersona =Integer.parseInt(nombrePersona);;
	    	if(numeroPersona==0) {
//	        Integer.parseInt(nombrePersona);
	        return true;
	    	}
	    } catch (NumberFormatException nfe){
	        return false;
	    }
		return false;
	}

}

