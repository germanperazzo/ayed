package TP2.ejercicio5;

import TP2.ejercicio1.*;

public class ProfundidadDeArbolBinario {
	
	private BinaryTree<Integer> a;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> unArbol) {
        a = unArbol;
    }
	
	public int sumaElementosProfundidad (int p) {
		int suma = 0;
		
		if(a!=null && !a.isEmpty() && 0 <= p){
			BinaryTree<Integer> aux = null;
			Queue<BinaryTree<Integer>> q = new Queue<BinaryTree<Integer>>();
			q.enqueue(a);
			q.enqueue(null);
			
			int nivel = 0;
			
			while(!q.isEmpty()) {
				
				aux = q.dequeue();

				if(aux != null) {
					
					if(nivel == p) {
						suma+= aux.getData();
					}
					
					if(nivel < p){
						
						if(aux.hasLeftChild()) {
							q.enqueue(aux.getLeftChild());
						}
						if(aux.hasRightChild()) {
							q.enqueue(aux.getRightChild());
						}
					}	
				}else if (!q.isEmpty()) {
					q.enqueue(null);
					nivel++;
				}
				
			}
		}
		return suma;
	}
	
	
	/*
	 
	  public int sumaElementosProfundidad(int p) {
        return (a!=null && !a.isEmpty()) ? sumaElementosProfundidad(p, a, 0) : 0;
    }
    
    private int sumaElementosProfundidad(int p, BinaryTree<Integer> a, int nivActual) {
        if(p == nivActual) {
            return ab.getData();
        } else {
            int suma = 0;
            if(a.hasLeftChild()) suma+= sumaElementosProfundidad(p, a.getLeftChild(), nivActual+1);
            if(a.hasRightChild()) suma+= sumaElementosProfundidad(p, a.getRightChild(), nivActual+1);
            return suma;
        }
    }
	 */
	
	
}
