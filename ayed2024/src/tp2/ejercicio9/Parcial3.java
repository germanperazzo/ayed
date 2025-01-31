package tp2.ejercicio9;

import tp2.ejercicio1.*;

public class Parcial3 {
	public BinaryTree<SumDif> sumAndDif(BinaryTree<Integer> arbol) {
        BinaryTree<SumDif> arbSad = new BinaryTree<SumDif>();
        if(!arbol.isEmpty()) {
            this.sumAndDif(arbol, arbSad, 0, 0);
        }
        return arbSad;
    }
    
    private void sumAndDif(BinaryTree<Integer> arbol, BinaryTree<SumDif> arbSad, int sum, int padre) {
        int datoActual = arbol.getData();
        SumDif sad = new SumDif(datoActual+sum, datoActual - padre);
        arbSad.setData(sad);
        if(arbol.hasLeftChild()) {
            arbSad.addLeftChild(new BinaryTree<SumDif>());
            sumAndDif(arbol.getLeftChild(), arbSad.getLeftChild(), sum+datoActual, datoActual);
        }
        if(arbol.hasRightChild()) {
            arbSad.addRightChild(new BinaryTree<SumDif>());
            sumAndDif(arbol.getRightChild(), arbSad.getRightChild(), sum+datoActual, datoActual);
        }
    }   
    
    public static void main(String[] args) {
        System.out.println("Test Ejercicio9");
        Parcial3 parcialArb = new Parcial3();
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(20);
        ab.addLeftChild(new BinaryTree<Integer>(5));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(-5));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(10));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.addRightChild(new BinaryTree<Integer>(30));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(50));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(-9));
        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(6));
        
        ab.entreNiveles(0, 4);
        System.out.println();
        System.out.println("Nuevo arbol:");
        parcialArb.sumAndDif(ab).entreNiveles(0, 4);
}
}    
