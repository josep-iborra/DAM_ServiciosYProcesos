package es.florida.AE1;
import java.util.ArrayList;

public class AE1_2 {
	
	public static void main(String[] args) {
		parteA();
		System.out.println();
		parteB();
	}
	//opcion a
	public static void parteA() {
		String[] compaClase= {"Pau", "Juanca", "Abel", "Miguel", "Jose","Jaume"};
			for(int i=0; i < compaClase.length;i++) {
				System.out.println(compaClase[i]);
			}

	}
	
	//opcion b
		public static void parteB() {
			 ArrayList<String> compaClases = new ArrayList<String>();
			 compaClases.add("Miguel");
			 compaClases.add("Julio");
			 compaClases.add("Raquel");
			 compaClases.add("Laia");
			 compaClases.add("Jose");
			 compaClases.add("Alberto");
			 for(int i=0; i<compaClases.size(); i++) {
				 System.out.println(compaClases.get(i));
			 }
			    

		}
	

}
