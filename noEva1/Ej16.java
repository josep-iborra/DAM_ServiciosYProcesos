package es.florida.noEva1;
import java.util.Scanner;

public class Ej16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce tu fecha de nacimiento");
		System.out.print("día: ");
		int dia =Integer.parseInt(sc.nextLine());
		System.out.print("mes: ");
		int mes =Integer.parseInt(sc.nextLine());
		System.out.print("año: ");
		int año =Integer.parseInt(sc.nextLine());
		int suma = dia + mes + año;
		
		int cifra1 = suma/1000; // primera cifra
		int cifra2 = suma/100%10; //segunda cifra
		int cifra3 = suma/10%10; //tercera cifra
		int cifra4 = suma%10; //última cifra
		int suerte = cifra1 + cifra2 + cifra3 + cifra4;
		
		System.out.println("Su número de la suerte es: " + suerte);
		
		
		
		sc.close();
   }
 }
