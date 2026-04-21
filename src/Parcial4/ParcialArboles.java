package Parcial4;

import java.util.Iterator;

import TP2.ejercicio1.Queue;
import TP3.ejercicio1.GeneralTree;

public class ParcialArboles {
	
	public GeneralTree<String> tesoroAccesibleMasCercanoGeneralTree (GeneralTree<String> camaras){
		GeneralTree<String> resultado = new GeneralTree<String>();
		
		if((camaras != null) && !camaras.isEmpty() ) {
			
			boolean ok = false;
			
			GeneralTree<String> aux;
	        Queue<GeneralTree<String>> q = new Queue<GeneralTree<String>>();
	        
	        q.enqueue(camaras);
	        
	        while(!ok && !q.isEmpty()) {
	        	aux = q.dequeue();
	        		
	        	Iterator<GeneralTree<String>> it = aux.getChildren().iterator();
	        	while(!ok && it.hasNext()) {
	    			GeneralTree<String> hijo = it.next();
	    				
	    			if(!aux.getData().equals("Bloqueo")) {
	    				if(hijo.getData().equals("Tesoro")) {
	    	        			
	    	        		ok = true;
	    	        		resultado = hijo;
	    	        	}else {
	    	        		q.enqueue(hijo);
	    	        	}
	    					
	    			}
	        	}	
	        }
		 }
		
		return resultado;
	}
	
	
}
