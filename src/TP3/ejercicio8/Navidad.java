package TP3.ejercicio8;

import TP3.ejercicio1.*;
import java.util.*;

public class Navidad {

	 private GeneralTree<Integer> ab;
	    
	    public Navidad(GeneralTree<Integer> ab) {
	        this.ab = ab;
	    }
	    
	    public String esAbetoNavidenio() {
	        boolean res = isAbeto(ab);
	        return res ? "Yes" : "No";
	    }
	    
	    
	    private boolean isAbeto(GeneralTree<Integer> a) {
	        int nodosHoja = 0;
	        boolean ok = true;
	        
	        Iterator<GeneralTree<Integer>> it = a.getChildren().iterator();
	        
	        while(it.hasNext() && ok ) {
	        	GeneralTree<Integer> child = it.next();
	        	
	        	if(child.isLeaf()) nodosHoja++;
	            else ok = isAbeto(child);
	        }
	        
	        if (ok &&(nodosHoja < 3)) {
	            ok = false;
	        }
	        return ok;
	    }
}
