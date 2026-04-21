package Parcial2;

import TP3.ejercicio1.*;
import java.util.*;

public class ParcialArboles {

	public static List<Integer> caminoSignoAlternante(GeneralTree<Integer> arbol) {
	    List<Integer> lista = new LinkedList<Integer>();
	    
	    if (arbol != null && !arbol.isEmpty()) {
	        List<Integer> ListaActual = new LinkedList<>();
	        helper(arbol, lista, ListaActual, 0, Integer.MIN_VALUE);
	    }
	    
	    return lista;
	}
	private static int helper(GeneralTree<Integer> ag, List<Integer> mejor, List<Integer> actual, int sumaActual, int sumaMax) {

		int valor = ag.getData();

		sumaActual += valor;
		actual.add(valor);

		if (ag.isLeaf()) {
			if (sumaActual > sumaMax) {
				sumaMax = sumaActual;
				mejor.clear();
				mejor.addAll(actual);
			}
		} else {
			for (GeneralTree<Integer> hijo : ag.getChildren()) {

				int vHijo = hijo.getData();

				
				if ((valor >= 0) != (vHijo >= 0)) {
					sumaMax = helper(hijo, mejor, actual, sumaActual, sumaMax);
				}
			}
		}

		
		actual.remove(actual.size() - 1);

		return sumaMax;
	}
}
