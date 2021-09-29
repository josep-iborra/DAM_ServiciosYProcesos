package es.florida.noEva1;
import java.util.Scanner;

public class Ej12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double nota=0;
		int matricula=0;
		int sobresalientes =0;
		int notables=0;
		int aprobados=0;
		int suspensos=0;
		int i=0;
		
			do {
				System.out.println("Dime tu nota:");
				nota = Double.parseDouble(sc.nextLine());
					if(nota < 5) {
						suspensos ++;
						}else if (nota >= 5 && nota < 6) {
							aprobados ++;
						}else if (nota >= 6 && nota < 7) {
							aprobados ++;
						}else if (nota >= 7 && nota < 9) {
							notables ++;
						}else if (nota >= 9 && nota < 10) {
							sobresalientes ++;
						}else if (nota == 10) {
							matricula ++;
						}else if (nota > 10) {
							System.out.println("Has introducido una nota que no es válida");
						i --;
					}
			i++;
			}while(i<10);
			System.out.println("Has optenido: " + matricula + " matriculas, " + sobresalientes + " sobresalientes, " + notables + " notables, " + aprobados + " aprobados, " + suspensos + " suspensos");
			
			sc.close();
   }
 }
