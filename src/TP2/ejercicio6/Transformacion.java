package TP2.ejercicio6;

import TP2.ejercicio1.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> ab;
	
	public Transformacion(BinaryTree<Integer> unArbol) {
        ab = unArbol;
    }
	
	public BinaryTree<Integer> suma() {
		if ((ab != null) && (!ab.isEmpty())) {
	        suma(ab);
	    }
		
		return ab;
	}
	
	private int suma(BinaryTree<Integer>a){
		
		int suma = 0;
		
		if(a.isLeaf()) {
			suma = a.getData();
			a.setData(0);
		} else {
			if(a.hasLeftChild()) {
	            suma+= suma(a.getLeftChild());
	        }
	        if(a.hasRightChild()) {
	            suma+= suma(a.getRightChild());
	        }
	        int actual = a.getData();
	        a.setData(suma);
	        suma+=actual;
		}
		
		return suma;
	}
}
