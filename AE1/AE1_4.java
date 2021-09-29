package es.florida.AE1;


public class AE1_4 {
	
	public static void main(String[] args) {
		int factorial = 1;
		for (int i = 2; i<= 15; i++) {
			factorial *= i;
		}
		System.out.println("El factorial del numero 15 es: "+ Integer.toString(factorial));
	}
	

}
