package TP3.ejercicio4;

import TP2.ejercicio1.*;
import TP3.ejercicio1.GeneralTree;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		double prom;
		double promMax = Double.NEGATIVE_INFINITY;
		
		int sum = 0;
		int cant = 1;
		
		if((arbol != null ) && (!arbol.isEmpty())) {
		
			GeneralTree<AreaEmpresa> aux;
	        Queue<GeneralTree<AreaEmpresa>> q = new Queue<GeneralTree<AreaEmpresa>>();
	        
	        q.enqueue(arbol);
			q.enqueue(null);
			
			while(!q.isEmpty()) {
				aux = q.dequeue();
				
				if(aux != null) {
					sum += aux.getData().getTardanza();
					
					for (GeneralTree<AreaEmpresa> child : aux.getChildren()) {
	                    q.enqueue(child);
	                }
					
				}else {
					prom= (double) sum/cant;
					
					if(prom > promMax) promMax= prom;
					
					sum = 0;
					cant = q.size();
					
					if(!q.isEmpty()) q.enqueue(null);
				}
				
			}
		}
		
		return promMax;
	}
	
}
