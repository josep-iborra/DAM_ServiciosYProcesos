package es.florida.noEva1;
import java.util.Scanner;

public class Ej18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce la contraseña: ");
		String pwd=sc.nextLine();
		
		if(pwd.length() >= 5) {
			System.out.println("La contraseña: " + pwd + " tiene un tamaño de un mínimo de 5 caracteres");
			boolean number =false;
			boolean capitalLetter = false;
			
			//Convertir la contraseña en array
			String[] pwdArray = pwd.split("");
			
			//Comparar cada letra de la contraseña
			for(int i=0; i< pwd.length(); i++) {
				//compruebo la contraseña si tiene alguna mayuscula
				if(Character.isUpperCase(pwdArray[i].toCharArray()[0])){
				capitalLetter=true;
				}
				try {
					Integer.parseInt(pwdArray[i]);
					number=true;
				}catch(NumberFormatException e) {
				}
			}
			// Compruebo si number y capitalLetter es true o false
			if(number) {
				System.out.println("La contraseña: " + pwd + " contiene, al menos, un número");
				if (capitalLetter) {
					System.out.println("La contraseña: " + pwd + " contiene, al menos, una letra en mayúscula");
				}else {
					System.out.println("La contraseña: " + pwd + " no contiene ninguna letra en mayúscula");
				}
			}else {
				System.out.println("La contraseña: " + pwd + " no contiene ningún número");
			}
		}else {
			System.out.println("La contraseña tiene menos de 5 caracteres");
		}
		
		sc.close();
   }
 }
