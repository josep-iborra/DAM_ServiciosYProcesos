package es.florida.noEva1;
import java.util.Scanner;

public class Ej13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime los grados Cº: ");
		double centigrados = Double.parseDouble(sc.nextLine());
		double farenhentDegrees=centigrados;
		
		farenhentDegrees= farenhentDegrees*2 - farenhentDegrees /5;
		
		farenhentDegrees+=32;
		System.out.println(String.format("%.1f", farenhentDegrees)+" ºF");
			sc.close();
   }
 }
