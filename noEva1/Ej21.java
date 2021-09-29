package es.florida.noEva1;
import java.util.Scanner;

public class Ej21 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int i = 0;
		String nombrePersona;
		do {
		System.out.print("Por favor introduzca un nombre: ");
		nombrePersona = sc.nextLine();
		System.out.println(nombrePersona);
		i++;
		}while (i < 5);
		
		
		sc.close();
		
   }
 }
