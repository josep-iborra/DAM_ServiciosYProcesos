package es.florida.T3_eva;

import java.util.ArrayList;

public class App {
	/* Metode: main
	*Descripcio: Crea una mina i li anyadix un limit, crea els miners i els fils, tambe fa que el ventilador alterne entre els dos misatges que te.
	*Parametres d'entrada:	
	*Parametres d'exida: 
*/
	public static void main(String[] args) {
		Mina mina1 = new Mina(100);
		ArrayList<Minero> mineros = new ArrayList();

		for (int i = 0; i < 10; i++) {
			Minero minero = new Minero(mina1);
			mineros.add(minero);
			Thread hiloMinero = new Thread(minero);
			hiloMinero.setName("minero " + i);
			hiloMinero.start();
		}
		
			Ventilador v = new Ventilador();
			Thread v1 = new Thread(new Runnable() {
				public void run() {
					v.encenderVentilador();
				}
			});
			Thread v2 = new Thread(new Runnable() {
				public void run() {
					v.apagarVentilador();
				}
			});
			v1.start();
			v2.start();
			
		
	
		try {
			Thread.sleep(15000);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int suma = 0;
		for (int i = 0; i < mineros.size(); i++) {
			suma += mineros.get(i).bolsa;

		}
		System.out.println("El stock de la mina es: " + mina1.stock);
		System.out.println("El total recolectado por los mineros es: " + suma);

	}

}
