package Parcial1;

import TP3.ejercicio1.*;
import java.util.*;

public class ParcialArboles {
	
	public static List<Integer> caminoParidadAlterno(GeneralTree<Integer> a) {
	    List<Integer> mejor = new LinkedList<Integer>();
	    
	    if (a != null && !a.isEmpty()) {
	        List<Integer> actual = new LinkedList<Integer>();
	        helper(a, actual, mejor);
	    }
	    
	    return mejor;
	}

	private static void helper(GeneralTree<Integer> nodo, List<Integer> actual, List<Integer> mejor) {

	    
	    actual.add(nodo.getData());

	    
	    if (nodo.isLeaf()) {
	        if (actual.size() > mejor.size()) {
	            mejor.clear();
	            mejor.addAll(actual);
	        }
	    } else {
	        for (GeneralTree<Integer> hijo : nodo.getChildren()) {

	           
	            if ((hijo.getData() % 2 == 0) != (nodo.getData() % 2 == 0)) {
	                helper(hijo, actual, mejor);
	            }
	        }
	    }

	    
	    actual.remove(actual.size() - 1);
	}
	
	
}
