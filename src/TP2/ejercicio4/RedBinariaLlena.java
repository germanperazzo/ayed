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
    
    private int retardoReenvio(BinaryTree<Integer> ab) {
    	
    	if (ab.isLeaf()) return ab.getData(); 
    	
    	int izq = ab.hasLeftChild() ? retardoReenvio(ab.getLeftChild()) : 0; 
    	int der = ab.hasRightChild() ? retardoReenvio(ab.getRightChild()) : 0; 
    	
    	if (izq <= der) 
    		return ab.getData() + der; 
    	else 
    		return ab.getData() + izq;
    }
    
}
