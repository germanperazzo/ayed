package TP2.ejercicio3;

import java.util.*;
import TP2.ejercicio1.*;

public class ContadorArbol {
	
	private BinaryTree<Integer> ab;
	
	public ContadorArbol(BinaryTree<Integer> unArbol) {
        ab = unArbol;
    }
	
	public List <Integer> numerosParesPre() {
		List <Integer> l = new LinkedList<Integer>();
		
		if((ab != null ) && (!ab.isEmpty())) this.nParesPre(l ,ab);
		
		return l;
	}
	
	private void nParesPre(List<Integer> l, BinaryTree<Integer> a){
		if(a.getData() %2 == 0) l.add(a.getData());
		if(a.hasLeftChild()) nParesPre(l, a.getLeftChild());
        if(a.hasRightChild()) nParesPre(l, a.getRightChild());
	}
	
	public List <Integer> numerosParesIn() {
		List <Integer> l = new LinkedList<Integer>();
		
		if((ab != null ) && (!ab.isEmpty())) this.nParesIn(l ,ab);
		
		return l;
	}
	
	private void nParesIn(List<Integer> l, BinaryTree<Integer> a){
		
		if(a.hasLeftChild()) nParesPre(l, a.getLeftChild());
		if(a.getData() %2 == 0) l.add(a.getData());
        if(a.hasRightChild()) nParesPre(l, a.getRightChild());
	}
}
