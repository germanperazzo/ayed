package TP3.ejercicio9;


import java.util.Iterator;

import TP3.ejercicio1.*;

public class ParcialArboles {
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		
		return ((arbol != null ) && (!arbol.isEmpty())) ? helper(arbol): false;	
	}
	
	private static boolean helper(GeneralTree<Integer> ag) {
		
		if(ag.isLeaf()) {
		    return true;
		} else {
			Integer min = Integer.MAX_VALUE;
		    boolean ok = true;
		    
			Iterator<GeneralTree<Integer>> it = ag.getChildren().iterator();
			
			while(it.hasNext() && ok ) {
				
				GeneralTree<Integer> child = it.next();
				
				min = Math.min(min, child.getData());
				ok = helper(child);
        
        	}
			
			return ( ok && (min == ag.getData()) );
		}

	}
}

/*
public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
    Queue<GeneralTree<Integer>> q = new Queue<GeneralTree<Integer>>();
    boolean ok = true; //Se considera que un arbol vacio devolvera true
    if(!arbol.isEmpty()) {
        q.enqueue(arbol);
        while(!q.isEmpty() && ok) {
            GeneralTree<Integer> aux = q.dequeue();
            int min = Integer.MAX_VALUE;
            for (GeneralTree<Integer> h: aux.getChildren()) {
                q.enqueue(h);
                min = Math.min(min, h.getData());
            }
            if(!aux.isLeaf() && aux.getData() != min) ok = false;
        }
    }
    return ok;
} */   