package TP3.ejercicio1;


import java.util.LinkedList;
import java.util.List;

import TP2.ejercicio1.*;


public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	/* Ejercicio2
	b) Si ahora tuviera que implementar estos métodos en la clase GeneralTree<T>, ¿qué modificaciones
	haría tanto en la firma como en la implementación de los mismos? */
	
	public List<Integer> numerosImparesMayoresQuePreOrden(Integer n){
		
		List <Integer> l = new LinkedList<Integer>();
		
		if((this != null ) && (!this.isEmpty())) this.numerosImparesMayoresQuePreOrden(l,n);
		
		return l;
	} 
	
	private void numerosImparesMayoresQuePreOrden( List<Integer> l, Integer n){
		
		int dato = (Integer) this.getData();
				
		if((dato % 2 != 0) && dato>n) l.add(dato);
		
		List<GeneralTree<T>> children = this.getChildren();
		for(GeneralTree<T> child: children ){
			child.numerosImparesMayoresQuePreOrden(l,n);
		}
		
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden(Integer n){
		List <Integer> l = new LinkedList<Integer>();
		
		if((this != null ) && (!this.isEmpty())) this.numerosImparesMayoresQueInOrden(l,n);
		
		return l;
	}
	
	private void numerosImparesMayoresQueInOrden(List<Integer> l, Integer n) {
		
		List<GeneralTree<T>> children = this.getChildren();
		
		if(this.hasChildren()) children.get(0).numerosImparesMayoresQueInOrden(l, n);
		
		 int dato = (Integer) this.getData();
	     if(dato %2 != 0 && dato > n) l.add(dato);
		
		for (int i = 1; i < children.size(); i++) {
			children.get(i).numerosImparesMayoresQuePreOrden(l,n);
		}
	}
	
	
	public List<Integer> numerosImparesMayoresQuePostOrden(Integer n){
		List <Integer> l = new LinkedList<Integer>();
		
		if((this != null ) && (!this.isEmpty())) numerosImparesMayoresQuePostOrden(l,n);
		
		return l;
	}
	
	private void numerosImparesMayoresQuePostOrden(List<Integer> l, Integer n) {
		List<GeneralTree<T>> children = this.getChildren();
		for(GeneralTree<T> child : children) {
			child.numerosImparesMayoresQueInOrden(l,n);
		}
		
		int dato = (Integer) this.getData();
	    if(dato %2 != 0 && dato > n) l.add(dato);
	}
	
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(Integer n){
		List <Integer> l = new LinkedList<Integer>();
		
		if((this != null ) && (!this.isEmpty())) {
			
			GeneralTree<T> aux;
			Queue<GeneralTree<T>> q = new Queue<GeneralTree<T>>();
			
			q.enqueue(this);
			
			while(!q.isEmpty()) {
				aux = q.dequeue();
				
				int dato = (Integer) aux.getData();
	        	if((dato % 2 != 0) && dato>n) l.add(dato);
	        	
	        	List<GeneralTree<T>> children = aux.getChildren();
	        	for (GeneralTree<T> child: children) {
	    			q.enqueue(child);
	    		}
			}
		}
		return l;
	}
	
	/**/
	
	public int altura() {	 
			
		return ((this != null ) && (!this.isEmpty())) ? alturaHelper() : -1;
	}
	
	private int alturaHelper() {
		if (this.isLeaf()) return 0;
		else {
			int alturaMax = -1;
			 List<GeneralTree<T>> children = this.getChildren();
	         for(GeneralTree<T> child: children) {
	            alturaMax = Math.max(alturaMax, child.alturaHelper());
	         }
	         return alturaMax + 1;
		}
	}
	
	
	
	
	
	public int nivel(T dato){
		return ((this != null ) && (!this.isEmpty())) ? nivelHelper(dato, 0) : -1;
	  }

	private int nivelHelper(T dato,int nivel) {
	
		if(this.getData().equals(dato)) {
			return nivel;
		}
		
		for (GeneralTree<T> child : this.getChildren()) {
	        int res = child.nivelHelper(dato, nivel + 1);
	        if (res != -1) {
	            return res; // corto apenas encuentro
	        }
	    }
		
		return -1;
	}
	
	
	public int ancho(){
		int max = Integer.MIN_VALUE;
		int cant = 0;
		
		if((this != null ) && (!this.isEmpty())) {
			GeneralTree<T> aux;
			Queue<GeneralTree<T>> q = new Queue<GeneralTree<T>>();
			
			q.enqueue(this);
			q.enqueue(null);
			
			while(!q.isEmpty()) {
				aux = q.dequeue();
				
				if(aux != null) {
					cant++;
					
					for(GeneralTree<T> child : aux.getChildren()) {
						q.enqueue(child);
						
					}
					
				}else {
					if(cant>max) max = cant;
					cant = 0;
					if(!q.isEmpty()) q.enqueue(null);
				}
			}
			
		}
		return max;
	}
	
	
	public boolean esAncestro(T a, T b) {
		
		if((this.isEmpty())) return false;
		
		return buscarA(a,b);
	}
	
	private boolean buscarA(T a, T b) {
		
		boolean ok = false;
		GeneralTree<T> aux = null;
	
		Queue<GeneralTree<T>> q = new Queue<GeneralTree<T>>();
		q.enqueue(this);
		
		while(!q.isEmpty() && !ok) {
			aux = q.dequeue();
			
			if(aux.getData().equals(b)) return false;
			if(aux.getData().equals(a)) {
				ok = true;

			}
			if(!ok) {
				for(GeneralTree<T> child: aux.getChildren()) {
					q.enqueue(child);
				}
			}
			
			
		}
		
		return ok ? buscarB(aux,b): ok;
	}
	
	private boolean buscarB(GeneralTree<T> ab, T b) {
		GeneralTree<T> aux;
        Queue<GeneralTree<T>> q = new Queue<GeneralTree<T>>();
        q.enqueue(ab);
        while(!q.isEmpty()) {
        	
        	aux = q.dequeue();
            if(aux.getData().equals(b)) {
                return true;
            } else {
                List<GeneralTree<T>> children = aux.getChildren();
                for (GeneralTree<T> child: children) {
                    q.enqueue(child);
                }
            }
        }
        
		return false;
	}
	
}