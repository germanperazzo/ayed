package TP3.ejercicio10;

import TP3.ejercicio1.*;

import java.util.*;


public class ParcialArboles {
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> l = new LinkedList<Integer>();
		
		if((arbol != null ) && (!arbol.isEmpty())) {
			helper(arbol , l, new LinkedList<Integer>(), Integer.MIN_VALUE, 0, 0);
		}
		return l;
	}
	
	public static int helper(GeneralTree<Integer> ag, List<Integer> camMax, List<Integer> camAct, int sumaMax, int sumaAct,int nivel) {
		
		int datoActual = ag.getData();
		
		if (datoActual == 1) {
			sumaAct+=   nivel;
			camAct.add(datoActual);
		}
		
		if(ag.isLeaf()) {
			if(sumaAct > sumaMax) {
				sumaMax = sumaAct;
				
				camMax.clear();
				camMax.addAll(camAct);
			}
		} else {
			for (GeneralTree<Integer> hijo: ag.getChildren()) {
				sumaMax = helper(hijo, camMax, camAct, sumaMax, sumaAct, nivel+1);
				
			}
			
		}
		
		if(datoActual == 1) camAct.remove(camAct.size()-1);
		
		return sumaMax;
	}
}
