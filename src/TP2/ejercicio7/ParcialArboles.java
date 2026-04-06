package TP2.ejercicio7;

import TP2.ejercicio1.*;

public class ParcialArboles {

	private BinaryTree<Integer> ab;
    
    public ParcialArboles(BinaryTree<Integer> ab) {
        this.ab = ab;
    }
    
    private int contarUnicoHijo(BinaryTree<Integer> arb) {
        int cant = 0;
        if(arb.hasLeftChild() ^ arb.hasRightChild()) cant++;
        if(arb.hasLeftChild()) cant += contarUnicoHijo(arb.getLeftChild());
        if(arb.hasRightChild()) cant += contarUnicoHijo(arb.getRightChild());
        
        return cant;
    }
    
    private boolean isLeftTree(BinaryTree<Integer> arb) {
        int ramaIzq = arb.hasLeftChild() ? contarUnicoHijo(arb.getLeftChild()) : -1;
        int ramaDer = arb.hasRightChild() ? contarUnicoHijo(arb.getRightChild()) : -1;
        return ramaIzq > ramaDer;
    }
    
    private boolean buscar(BinaryTree<Integer> ab, int num) {
    	boolean ok = false;
    	if(ab.getData() == num) {
    		return isLeftTree(ab);
    	}else {
    		if(ab.hasLeftChild()) ok = buscar(ab.getLeftChild(), num);
    		if(!ok && ab.hasRightChild()) ok = buscar(ab.getRightChild(), num);
    		return ok;
    	}
    	
    }
    
    public boolean isLeftTree(int num) {
    	
    	return (ab !=null && !ab.isEmpty()) ? buscar(ab,num) : false;
    }
    
}
