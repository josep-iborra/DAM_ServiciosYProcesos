package es.florida.noEva1;
import java.util.Scanner;

public class Ej15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime el radio de la circunferencia: ");
		double radio= Double.parseDouble(sc.nextLine());
		
		double diametro = radio*2;
		double area= Math.PI * Math.pow(radio,2);
		 double volumen=4 * Math.PI * Math.pow(radio, 3) / 3;
		
	System.out.println(String.format("%.3f",diametro)+ " cm de diametro");
	System.out.println(String.format("%.3f",area)+ " cm de area");		
	 System.out.println(String.format("%.3f", volumen) + " cm de volumen");	
		sc.close();
   }
 }
