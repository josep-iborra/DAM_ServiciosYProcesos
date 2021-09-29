package es.florida.AE1;


import java.util.Scanner;

public class AE1_8 {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		 System.out.print("Dime un numero: ");
		 int num1 = Integer.parseInt(sc.nextLine());
		 
		 System.out.print("Dime otro numero: ");
		 int num2 = Integer.parseInt(sc.nextLine());
		 
		
		 if(num1 < num2) {
			 
			 long tiempoIni =System.nanoTime();
			 for(int i=num1; i<=num2;i++) {
				if(isPrime(i)) {
					System.out.println(String.valueOf(i)+ " Es Primo");
				}else {
					System.out.println(String.valueOf(i)+ " No es Primo");
				}
			}
			 long tiempoF = System.nanoTime();
			 double tiempoMili =(tiempoF-tiempoIni)/1e6;
			 double tiempoSeg =(tiempoMili)/1000;
			 
			 if(tiempoSeg <= 0.001) {
				  System.out.println("Duración: " + String.format ("%.3f",tiempoSeg) + " segundo");
			 }else if(tiempoSeg > 0.001) {
				 System.out.println("Duración: " + String.format ("%.3f",tiempoSeg) + " segundos");
			 }
		 }
		 sc.close();
	}
	public static boolean isPrime(int number) {
		
		 if(number == 0 || number == 1 || number==4 ) {
			 return false;
		 }
		 for(int i = 2; i<number/2; i++) {
			 if(number% i == 0) {
				 return false;
			 }
			 
		 }
		 return true;
		}
		
	
	}


