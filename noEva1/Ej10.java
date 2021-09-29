package es.florida.noEva1;
import java.util.Scanner;

public class Ej10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Introduce el numero del mes: ");
		 int a =Integer.parseInt(sc.nextLine());
		
		 if(a>=1 && a<=12 ) {
			 if(a == 1){
				 System.out.println("Enero");
			 }else if(a == 2){
				 System.out.println("Febrero");
			 }else if(a == 3){
				 System.out.println("Marzo");
			 }else if(a == 4){
				 System.out.println("Abril");
			 }else if(a == 5){
				 System.out.println("Mayo");
			 }else if(a == 6){
				 System.out.println("Junio");
			 }else if(a == 7){
				 System.out.println("Julio");
			 }else if(a == 8){
				 System.out.println("Agosto");
			 }else if(a == 9){
				 System.out.println("Septiembre");
			 }else if(a == 10){
				 System.out.println("Octubre");
			 }else if(a == 11){
				 System.out.println("Noviembre");
			 }else if(a == 12){
				 System.out.println("Diciembre");
			 }
		sc.close();
		
		}
	}
}