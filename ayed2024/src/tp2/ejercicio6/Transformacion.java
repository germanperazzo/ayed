package tp2.ejercicio6;

import tp2.ejercicio1.*;

public class Transformacion {
	private BinaryTree<Integer> tree;
	
	public BinaryTree<Integer> getTree() {
		return tree;
	}
	
	public Transformacion(BinaryTree<Integer> tree) {
		this.tree = tree;
	}
	
	
	public BinaryTree<Integer> suma() {
		suma(this.getTree());
		return this.getTree();
	}
	
	private int suma(BinaryTree<Integer> tree) {
		int total = 0;
		
		if (tree.isLeaf()) {
			total = tree.getData();
			tree.setData(0);
			return total;
		}
		
		if (tree.hasLeftChild()) {
			total+=suma(tree.getLeftChild());
		}
		
		if (tree.hasRightChild()) {
			total+=suma(tree.getRightChild());
		}
		
		int aux = tree.getData();
		tree.setData(total);
		return total+aux;
	}
	
}
