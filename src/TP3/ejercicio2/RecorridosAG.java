package TP3.ejercicio2;


import java.util.LinkedList;
import java.util.List;
import TP2.ejercicio1.*;
import TP3.ejercicio1.GeneralTree;

public class RecorridosAG {
	
	
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n){
		
		List <Integer> l = new LinkedList<Integer>();
		
		if((a != null ) && (!a.isEmpty())) numerosImparesMayoresQuePreOrden(a,l,n);
		
		return l;
	} 
	
	private void numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, List<Integer> l, Integer n){
		
		int dato = a.getData();
		if((dato % 2 != 0) && dato>n) l.add(dato);
		
		List<GeneralTree<Integer>> children = a.getChildren();
		for(GeneralTree<Integer> child: children ){
			numerosImparesMayoresQuePreOrden(child,l,n);
		}
		
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		List <Integer> l = new LinkedList<Integer>();
		
		if((a != null ) && (!a.isEmpty())) numerosImparesMayoresQueInOrden(a,l,n);
		
		return l;
	}

	private void numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,List<Integer> l,Integer n) {
		List<GeneralTree<Integer>> children = a.getChildren();
		
		if(a.hasChildren()) numerosImparesMayoresQueInOrden(children.get(0), l,n );
		
		int dato = a.getData();
		if((dato % 2 != 0) && dato>n) l.add(dato);
		
		for (int i = 1; i < children.size(); i++) {
			numerosImparesMayoresQueInOrden(children.get(i),l, n);
		}
		
	}
	
	public  List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree <Integer> a,Integer n) {
		List <Integer> l = new LinkedList<Integer>();
		
		if((a != null ) && (!a.isEmpty())) numerosImparesMayoresQuePostOrden(a,l,n);
		
		return l;
	}
	
	private void numerosImparesMayoresQuePostOrden(GeneralTree <Integer> a,List<Integer> l,Integer n) {
		
		List<GeneralTree<Integer>> children = a.getChildren();
		for(GeneralTree<Integer> child: children ){
			numerosImparesMayoresQuePreOrden(child,l,n);
		}
		
		int dato = a.getData();
		if((dato % 2 != 0) && dato>n) l.add(dato);
		
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
		List <Integer> l = new LinkedList<Integer>();
		
		if((a != null ) && (!a.isEmpty())) {
			
			GeneralTree<Integer> aux;
	        Queue<GeneralTree<Integer>> q = new Queue<GeneralTree<Integer>>();
	        q.enqueue(a);
			
	        while(!q.isEmpty()) {
	        	aux = q.dequeue();
	        	int dato = aux.getData();
	        	if((dato % 2 != 0) && dato>n) l.add(dato);
	        	
	        	List<GeneralTree<Integer>> children = aux.getChildren();
	        	for (GeneralTree<Integer> child: children) {
	    			q.enqueue(child);
	    		}
	        }
		}
		
		return l;
	}
	
	
}
