package tp1.ejercicio2;



public class Clase {
	public static int[] pepe(int n) {
		int[] array = new int [n];
		for(int i = 0; i<n; i++ ) {
			array[i]=(i+1)*n;
		}
		return array;
	}
}
