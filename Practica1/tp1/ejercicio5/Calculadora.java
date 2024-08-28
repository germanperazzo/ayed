package tp1.ejercicio5;

public class Calculadora {
	private static Dato varc;
	
	public static Dato calculadoraA(int[] enteros) {
		int min = 9999;
		int max = -9999;
		int total = 0;
		for (int e: enteros) {
			if (e < min) {
				min = e;
			}
			else {
				max = e;
			}
			total +=e;
		}
		return new Dato(max, min, (double) total/enteros.length);
	}
	
	public static void calculadoraB(int[] enteros, Dato dato){
		int min = 999999;
		int max = -999999;
		int total = 0;
		for (int e: enteros) {
			if (e < min) {
				min=e;
			} else if (e>max) {
				max=e;
			}
			total+=e;
		}
		dato.setMaximo(max);
		dato.setMinimo(min);
		dato.setPromedio( (float) total/enteros.length);
	}

	public static void calculadoraC(int[] enteros) {
		int min = 999999;
		int max = -999999;
		int total = 0;
		for (int e: enteros) {
			if (e < min) {
				min=e;
			} else if (e>max) {
				max=e;
			}
			total+=e;
		}
		varc = new Dato(max, min, (float) total/enteros.length);
	}

	public static Dato getVarc() {
		return varc;
	}
	
	
}