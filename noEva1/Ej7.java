package es.florida.noEva1;
import java.util.Scanner;

public class Ej7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		int suma=0;
		int i=0;
		
		while( i<=5 ) {

			System.out.println("Introduce un numero: ");
			int a = Integer.parseInt(sc.nextLine());
			suma = suma + a;
			i++;
		}
		System.out.println("La suma de todo es: "+ suma);
		sc.close();
		
		
	}
	}
	

	
		
		
