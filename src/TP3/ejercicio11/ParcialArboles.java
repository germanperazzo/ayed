package TP3.ejercicio11;

import TP2.ejercicio1.*;
import TP3.ejercicio1.GeneralTree;


public class ParcialArboles {

	public static boolean resolver(GeneralTree<Integer> arbol) {
		
		boolean ok = true;
		
		if((arbol != null ) && (!arbol.isEmpty())) {
			
			int cantActual = 0;
		    int nivel = 1;
			
			GeneralTree<Integer> aux;
	        Queue<GeneralTree<Integer>> q = new Queue<GeneralTree<Integer>>();
	        
	        q.enqueue(arbol);
			q.enqueue(null);
			
			while(ok && !q.isEmpty()) {
				aux = q.dequeue();
				
				if(aux != null) {
					cantActual++;
					
					if(cantActual >nivel) {
						ok = false;
					}
					else {
						for(GeneralTree<Integer> child: aux.getChildren()) {
							q.enqueue(child);
						}
					}
					
				}else {
					
					if(cantActual == nivel) {
						
						if(!q.isEmpty()) { q.enqueue(null);
						nivel++;
						cantActual=0;
						}
						
					}else ok = false;
					
					
				}
			}
			
		}
		
		return ok;
	}
	
}
