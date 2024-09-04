package tp2.ejercicio3;

import tp2.ejercicio1.*;
import java.util.*;

public class ContadorArbol {
	private BinaryTree<Integer> dato;

	public ContadorArbol(BinaryTree<Integer> dato) {
		super();
		this.dato = dato;
	}
	
	public List<Integer> numerosParesPost(){
		List <Integer> list = new  LinkedList<Integer>() ;
		
		contarParesPostOrden(list,dato);
		return list;
	}
	
	public List<Integer> numerosParesIN(){
		List <Integer> list = new  LinkedList<Integer>() ;
		contarParesInOrden(list,dato);
		
		return list;
	}
	
	private void contarParesInOrden(List<Integer> list,BinaryTree<Integer> arbol) {
		if(arbol.hasLeftChild()) {
			contarParesInOrden(list,arbol.getLeftChild());
		}
		
		
		if (arbol.getData() % 2 == 0) {
			list.add(arbol.getData());
		}
		
		if (arbol.hasRightChild()) {
			contarParesInOrden(list, arbol.getRightChild());
		}
		
	}
	
	private void contarParesPostOrden(List<Integer> list,BinaryTree<Integer> arbol) {
		if(arbol.hasLeftChild()) {
			contarParesPostOrden(list,arbol.getLeftChild());
		}
		
		if (arbol.hasRightChild()) {
			contarParesPostOrden(list, arbol.getRightChild());
		}
		
		if (arbol.getData() % 2 == 0) {
			list.add(arbol.getData());
		}
	
	}
	
}
