package es.florida.T3_eva;



public class Ventilador {
		boolean funcionamiento = true;
		int tiempo = 1000;
		/* Metode: encederVentilador
		*Descripcio: mostra el misatge i se espera al altre metod a que se acabe 
		*Parametres d'entrada:	
		*Parametres d'exida: 
		*/
		public void encenderVentilador() {
			
			while(true) {
				synchronized (this) {
					try {
						while (funcionamiento == true) wait();
						System.out.println("El ventilador esta encendido durante " + tiempo/1000 + " segundos");
						Thread.sleep(tiempo);
						funcionamiento =true;
						notify();
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		/* Metode: apagarVentilador
		*Descripcio: mostra el misatge i se espera al altre metod a que se acabe 
		*Parametres d'entrada:	
		*Parametres d'exida: 
		*/
		public void apagarVentilador() {
			while (true) {
				synchronized (this) {
					try {
						while (funcionamiento == false)
							wait();
						System.err.println("El ventilador esta apagado durante " + tiempo / 1000 + " segundos");
						Thread.sleep(tiempo);
						funcionamiento = false;
						notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		

		
	}

