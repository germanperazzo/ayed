package TP2.ejercicio8;

import TP2.ejercicio1.BinaryTree;

public class ParcialArboles {

	public boolean esPreFijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		
		boolean ok = false;
		
		if( arbol1 != null && arbol2 != null) {
			if(!arbol1.isEmpty() && !arbol2.isEmpty()) {
				ok = verificar(arbol1, arbol2);
			}
		}
		
		return ok;
	}
	
	private boolean verificar(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean ok = true;
		
	    if(!arbol1.getData().equals(arbol2.getData()))
	        return false;

	    if(arbol1.hasLeftChild()) {
	        if(arbol2.hasLeftChild())
	            ok = verificar(arbol1.getLeftChild(), arbol2.getLeftChild());
	        else
	            return false;
	    }

	    if(ok && arbol1.hasRightChild()) {
	        if(arbol2.hasRightChild())
	            ok = verificar(arbol1.getRightChild(), arbol2.getRightChild());
	        else
	            return false;
	    }
	    return ok;  
	}
}
