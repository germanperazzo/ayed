package Parcial3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import TP3.ejercicio1.GeneralTree;

public class ParcialArboles {
	
	
	public static List<Integer> primerCaminoAlternanteCeroNoCero(GeneralTree<Integer> arbol){
		
		List<Integer> lista = new LinkedList<Integer>(); 
		
		 if((arbol != null) && !arbol.isEmpty() ) {
			 
			 helper(arbol,lista);
		 }
		
		return lista;
	}
	
	
	private static Boolean helper( GeneralTree<Integer> ag, List<Integer> l) {
		
		Boolean encontre = false;
		l.add(ag.getData());
		
		if(ag.isLeaf()) encontre = true;
		else {
			Iterator<GeneralTree<Integer>> it = ag.getChildren().iterator();
			
			while(!encontre && it.hasNext()) {
				GeneralTree<Integer> hijo = it.next();
				
				if((ag.getData() % 10 == 0) != (hijo.getData() % 10 == 0)) {
					encontre = helper(hijo, l);
				}
			}
			
			if(encontre) l.remove(l.size()-1);
		}
		
		return encontre;
	}
	
}
