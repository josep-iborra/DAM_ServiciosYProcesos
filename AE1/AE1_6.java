package es.florida.AE1;

import java.util.ArrayList;
import java.util.Scanner;

public class AE1_6 {
	
	public static void main(String[] args) {
		numEnteros();
	}
	public static void numEnteros() {
		Scanner sc= new Scanner(System.in);
		 ArrayList<Integer> numeros = new ArrayList<Integer>();
		for(int i=0; i<5;i++) {
			System.out.println("Introduce un numero: ");
			Integer num= Integer.parseInt(sc.nextLine());
			System.out.println(num);
			
			numeros.add(num);
			
			    System.out.println(numeros);
		}
		
		sc.close();
	}

}
