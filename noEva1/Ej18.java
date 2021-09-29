package es.florida.noEva1;
import java.util.Scanner;

public class Ej18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce la contrase�a: ");
		String pwd=sc.nextLine();
		
		if(pwd.length() >= 5) {
			System.out.println("La contrase�a: " + pwd + " tiene un tama�o de un m�nimo de 5 caracteres");
			boolean number =false;
			boolean capitalLetter = false;
			
			//Convertir la contrase�a en array
			String[] pwdArray = pwd.split("");
			
			//Comparar cada letra de la contrase�a
			for(int i=0; i< pwd.length(); i++) {
				//compruebo la contrase�a si tiene alguna mayuscula
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
				System.out.println("La contrase�a: " + pwd + " contiene, al menos, un n�mero");
				if (capitalLetter) {
					System.out.println("La contrase�a: " + pwd + " contiene, al menos, una letra en may�scula");
				}else {
					System.out.println("La contrase�a: " + pwd + " no contiene ninguna letra en may�scula");
				}
			}else {
				System.out.println("La contrase�a: " + pwd + " no contiene ning�n n�mero");
			}
		}else {
			System.out.println("La contrase�a tiene menos de 5 caracteres");
		}
		
		sc.close();
   }
 }
