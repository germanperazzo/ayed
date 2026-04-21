package TP3.ejercicio6;

import TP3.ejercicio1.GeneralTree;

public class RedDeAguaPotable {
	private GeneralTree<Character> ab;
	
	public double minimoCaudal(double caudal) {
		 if(ab.isEmpty()) return 0;
	        return (!ab.isLeaf()) ? minimoCaudal(ab, caudal, Double.MIN_VALUE) : caudal;
	}
	
	private double minimoCaudal (GeneralTree<Character> ag, double caudal, double caudalM) {
		
		caudal = caudal / ag.getChildren().size();
		
		if(ag.isLeaf()) {
			
			if(caudal < caudalM) caudalM =caudal;
			
		}else {
			for (GeneralTree<Character> child : ag.getChildren()) {
				caudalM = minimoCaudal(child,caudal,caudalM);
			}
		}
		
		return caudalM;
	}
}
