package es.florida.noEva1;
import java.util.Scanner;

public class Ej4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce un numero: ");
		int a = Integer.parseInt(sc.nextLine());
		
		System.out.println("Introduce otro numero: ");
		int b = Integer.parseInt(sc.nextLine());
		
		if(a>b) {
			System.out.println(a+" Es mayor que: "+b);
		}else if(a<b) {
			System.out.println(a+" Es menor que: "+b);
		}else if(a==b) {
			System.out.println(a+" Y son iguales "+b);
		}
		

	
		sc.close();
		
	}

}
