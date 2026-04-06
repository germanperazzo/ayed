package TP2.ejercicio1;



public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
	   int suma = 0;
	   
	   if(this.isLeaf()) {
		   suma= 1;
	   }
	   else {
		   if(this.hasLeftChild()) {
			   suma += this.getLeftChild().contarHojas();
		   }
		   if(this.hasRightChild()) {
			   suma += this.getRightChild().contarHojas();
		   }
	   }
		return suma;
	}
		
		
    	 
    public BinaryTree<T> espejo(){
    	BinaryTree<T> arb = new BinaryTree<T>(this.getData());
    	
    	if(this.hasLeftChild()) {
    		arb.addRightChild(this.getLeftChild().espejo());
    	}
    	
    	if(this.hasRightChild()) {
    		arb.addLeftChild(this.getRightChild().espejo());
    	}
    	
 	   return arb;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		if(!this.isEmpty() || 0 <= n || n< m) {
			
			BinaryTree<T> aux = null;
			Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
			cola.enqueue(this);
			cola.enqueue(null);
			
			int nivel = 0;
			
			while(!cola.isEmpty()) {
				
				aux = cola.dequeue();
				if(aux != null) {
					
					if(nivel >= n) {
						System.out.println(aux.getData());
					}
					
					if(nivel < m){
						if(aux.hasLeftChild()) {
							cola.enqueue(aux.getLeftChild());
						}
						if(aux.hasRightChild()) {
							cola.enqueue(aux.getRightChild());
						}
					}
				} else if (!cola.isEmpty()) {
					cola.enqueue(null);
					nivel++;
				}
				
			}
			
		}

   }
		
}

