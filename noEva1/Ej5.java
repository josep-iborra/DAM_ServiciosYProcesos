package es.florida.noEva1;
import java.util.Scanner;

public class Ej5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=0;
		int b=0;
		
		do {
			Scanner sc= new Scanner(System.in);
		
			System.out.println("Introduce un numero: ");
			a =Integer.parseInt(sc.nextLine());
				
			System.out.println("Introduce otro numero: "); 
			b =Integer.parseInt(sc.nextLine());
			sc.close();
			
		}while(a!=b);
		System.out.println(a+ " son iguales "+b);
		
	}
	}
	

	
		
		
