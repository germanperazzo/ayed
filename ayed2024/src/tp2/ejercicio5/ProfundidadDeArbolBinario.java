package tp2.ejercicio5;


import tp2.ejercicio1.*;
import tp2.ejercicio1.Queue;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> tree;
	
	public BinaryTree<Integer> getTree(){
		return tree;
	}
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> tree) {
		this.tree = tree;
	}
	
	public int entreNiveles(int n){
		Queue<BinaryTree<Integer>> queue = new Queue<BinaryTree<Integer>>();
		Queue<Integer> levels  = new Queue<Integer>();
		
		queue.enqueue(this.getTree());
		levels.enqueue(0);
		
		int suma = 0;
		
		while (!queue.isEmpty()) {
			BinaryTree<Integer> e = queue.dequeue();
			int l = levels.dequeue();
			
			if (l == n) {				
				suma+= e.getData();
			}

			if ((e.hasLeftChild()) && (l<n)) {
				levels.enqueue(l+1);
				queue.enqueue(e.getLeftChild());
			}
			
			if ((e.hasRightChild()) && (l < n)) {
				levels.enqueue(l+1);
				queue.enqueue(e.getRightChild());
			}
		}
		return suma;
	}
	
}
