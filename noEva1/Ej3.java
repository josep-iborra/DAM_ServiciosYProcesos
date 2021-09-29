package es.florida.noEva1;
import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce un numero: ");
		int a = Integer.parseInt(sc.nextLine());
		
		System.out.println("Introduce otro numero: ");
		int b = Integer.parseInt(sc.nextLine());
		
		int suma = a +b;
		
		System.out.println("la suma es: "+ suma);

	
		sc.close();
		
	}

}
