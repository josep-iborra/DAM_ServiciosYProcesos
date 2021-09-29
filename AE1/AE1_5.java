package es.florida.AE1;


public class AE1_5 {
	
	public static void main(String[] args) {
		ListElement();
	}
	public static void ListElement() {
		int[] num = {2,8,9,11,17,7,5,19,3};
		int largeElement = num[0];
		for(int i=0; i<num.length; i++) {
			if(num[i]>largeElement) {
				largeElement = num[i];
			}
		}
		System.out.println("El numero mayor es: "+ largeElement);
	}

}
