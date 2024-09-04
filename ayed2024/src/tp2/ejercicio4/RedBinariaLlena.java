package tp2.ejercicio4;

import tp2.ejercicio1.*;

public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;

	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	public int retardoReenvio() {
		return retardoReenvio(arbol);
	}
	
	private int retardoReenvio (BinaryTree<Integer> arbol) {
		if (arbol.isEmpty())
			return - 1;
		
		int cant = -1;
		
		if (arbol.isEmpty())
			return arbol.getData();
		
		else {
			if (arbol.hasLeftChild()) 
				cant = Math.max(cant,retardoReenvio(arbol.getLeftChild()));
			if (arbol.hasRightChild())
				cant = Math.max (cant,retardoReenvio(arbol.getRightChild()));
		}
		return cant + arbol.getData();
	}
}
