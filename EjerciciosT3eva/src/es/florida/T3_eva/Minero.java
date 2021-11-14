package es.florida.T3_eva;

import es.florida.T3_eva.Mina;

public class Minero implements Runnable {
	int bolsa = 0;
	int tiempoExtraccion;
	Mina mina;
	

	Minero(Mina mina1) {
		tiempoExtraccion = 1000;
		this.mina = mina1;

	}
	/* Metode: extraerRecurso
	*Descripcio: mostra el misatge amb el nom del minero la cantitat que te en la bolsa i la cantitat de la del stock que hi ha en la mina
	*Parametres d'entrada:	
	*Parametres d'exida: 
	*/

	synchronized public void extraerRecurso() {
		while (mina.stock != 0) {
			System.out.println("El " + Thread.currentThread().getName() + " ha extraido: " + bolsa + " recurso y el stock de la mina es: "+mina.stock);
			mina.stock -= 1;
			bolsa++;
			try {
				Thread.sleep(tiempoExtraccion);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	
	/* Metode: run
	*Descripcio: mostra el misatge i se espera al altre metod a que acabe el temps
	*Parametres d'entrada:	
	*Parametres d'exida: 
	*/

	@Override
	public void run() {
		extraerRecurso();
		
	}

}
