package tp1.ejercicio5;

public class ej5 {

	public static void main(String[] args) {
				//A
				System.out.println(Calculadora.calculadoraA(new int []{1,4,7,2,10,5,3,6}).toString());
				
				//B
				Dato dato = new Dato(0, 0, 0);
				Calculadora.calculadoraB(new int[] {6,3,9,1,-23,10,1,2}, dato);
				
				System.out.println(dato.toString());
				
				//C
				System.out.println(Calculadora.getVarc()); //null
				Calculadora.calculadoraC(new int[] {-4,-3,-2,-1,1,2,3,4});
				System.out.println(Calculadora.getVarc().toString());
	}

}
