package TP2.ejercicio6;

import TP2.ejercicio1.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> a;
	
	public Transformacion(BinaryTree<Integer> unArbol) {
        a = unArbol;
    }
	
	public BinaryTree<Integer> suma() {
		if ((a != null) && (!a.isEmpty())) {
	        suma(ab);
	    }
		
		return ab;
	}
	
	private int suma(BinaryTree<Integer>ab){
		
		int suma = 0;
		
		if(ab.isLeaf()) {
			suma = ab.getData();
			ab.setData(0);
		} else {
			if(ab.hasLeftChild()) {
	            suma+= suma(ab.getLeftChild());
	        }
	        if(ab.hasRightChild()) {
	            suma+= suma(ab.getRightChild());
	        }
	        int actual = ab.getData();
	        ab.setData(suma);
	        suma+=actual;
		}
		
		return suma;
	}
}
