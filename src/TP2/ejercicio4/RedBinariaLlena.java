package TP2.ejercicio4;

  
import TP2.ejercicio1.*;

public class RedBinariaLlena {
	
	private BinaryTree<Integer> a;
    
    public RedBinariaLlena(BinaryTree<Integer> unArbolLleno) {
        this.a = unArbolLleno;
    }
	
    public int retardoReenvio() {
    	return ((a != null ) && (!a.isEmpty())) ? retardoReenvio(a) : 0; 
    }
    
    private int retardoReenvio(BinaryTree<Integer> a) {
    	
    	if (a.isLeaf()) return a.getData(); 
    	
    	int izq = a.hasLeftChild() ? retardoReenvio(a.getLeftChild()) : 0; 
    	int der = a.hasRightChild() ? retardoReenvio(a.getRightChild()) : 0; 
    	
    	if (izq <= der) 
    		return a.getData() + der; 
    	else 
    		return a.getData() + izq;
    }
    
}
