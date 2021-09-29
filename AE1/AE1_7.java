package es.florida.AE1;


import java.util.Scanner;

public class AE1_7 {
	
	public static void main(String[] args) {
		nivelXp();
	}
	public static void nivelXp() {
		Scanner sc= new Scanner(System.in);
		 System.out.print("Dime tu nombre");
		 String nombre = sc.nextLine();
		 
		 System.out.print("Dime tus años de experiencia");
		 int anyos = Integer.parseInt(sc.nextLine());
		 
		 if(anyos < 1) {
			 System.out.println("Desarrollador Junior L1 – 15000-18000");
		 }else if(anyos >= 1 && anyos >= 2){
			 System.out.println("Desarrollador Junior L2 – 18000-22000");
		 }else if(anyos >= 3 && anyos < 5){
			 System.out.println("Desarrollador Senior L1 – 22000-28000");
		 }else if(anyos >= 5 && anyos <= 8){
			 System.out.println("Desarrollador Senior L2 – 28000-36000");
		 }
		 else if(anyos < 8){
			 System.out.println("Analista / Arquitecto. Salario a convenir en base a rol");
		 }
		 sc.close();
		 
		}
		
	
	}


