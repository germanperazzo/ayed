package TP3.ejercicio7;

import TP3.ejercicio1.GeneralTree;
import java.util.*;

public class Caminos {

	private GeneralTree<Integer> ag;
	
	public List<Integer> caminoAHojaMasLejana (){
		List<Integer> camAct = new LinkedList<Integer>();
	    List<Integer> camMax = new LinkedList<Integer>();
	     
		if((ag != null ) && (!ag.isEmpty())) caminoHelper(ag, camAct, camMax);
		
		return camMax;
	}
	
	private void caminoHelper( GeneralTree<Integer> a, List<Integer> camAct, List<Integer> camMax) {
		camAct.add(a.getData());
		
		if(a.isLeaf()) {
			if(camAct.size() > camMax.size()) {
				
				camMax.removeAll(camMax);
	            camMax.addAll(camAct);
				
			}
		}else {
			for(GeneralTree<Integer> child : a.getChildren()) {
				caminoHelper(child, camAct, camMax);
			}
		}
		camAct.remove(camAct.size()-1);
	}
	
}
