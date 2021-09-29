package es.florida.AE1;
import java.util.Scanner;

public class AE1_3 {
	
	public static void main(String[] args) {
		sumPares();
	}
	public static void sumPares() {
		Scanner sc = new Scanner(System.in);
		int numPar = 0;
		
		System.out.println("Introduce un numero:");
		int hastaNum= Integer.parseInt(sc.nextLine());
		
		for(int i= 1; i<hastaNum; i++) {
			if(i % 2 == 0) {
				numPar += i;
			}
		}
		System.out.println("La suma de los numeros pares hasta el numero " + hastaNum +" es: " +numPar);
		
		sc.close();
	}

}
