package tp1.ejercicio1;

public class Clase {

	public static void  puntoA(int a, int b) {
		for (int i = a+1; i<= b; i++) {
			
			System.out.println(i);
		}
	}
	
	public static void puntoB(int a, int b) {
		while(a<b) {
			a++;
			System.out.println(a);
		}
	}
	
	public static void puntoC(int a, int b) {
		if(a<b) {
			a++;
			System.out.println(a);
			puntoC(a,b);
		}
		
	}
}
