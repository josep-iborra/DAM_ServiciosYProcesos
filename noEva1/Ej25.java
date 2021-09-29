package es.florida.noEva1;
import java.util.Scanner;
import java.util.*;

public class Ej25 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int num1;
		do {
			System.out.print("Dime un numero del 1 al 10: ");
			num1=Integer.parseInt(sc.nextLine());
		}while(!(num1>1 && num1<10));
		
		int aleatorio= (int) (Math.random()* 10);
		System.out.println("El numero es el: "+aleatorio);
		
		if(num1==aleatorio) {
			System.out.println("Has acertado el numero!!");
		}else {
			System.out.println("Prueba otra vez");
		
		}
		sc.close();

	}
}

