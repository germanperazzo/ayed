package TP2.ejercicio9;
import TP2.ejercicio1.*;

public class ParcialArboles {
	public BinaryTree<SumDif> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<SumDif> arbSad = new BinaryTree<SumDif>();
		
		if(arbol != null && !arbol.isEmpty()) {
			sumAndDifP(arbol, arbSad, 0, 0);
		}
		
		return arbSad;
	}
	
	private void sumAndDifP(BinaryTree<Integer> arbol, BinaryTree<SumDif> arbSad, int sum , int padre) {
		int datoActual = arbol.getData();
		
		SumDif sad = new SumDif(datoActual+sum, datoActual - padre);
		arbSad.setData(sad);
		
		if(arbol.hasLeftChild()) {
            arbSad.addLeftChild(new BinaryTree<SumDif>());
            sumAndDifP(arbol.getLeftChild(), arbSad.getLeftChild(), sum+datoActual, datoActual);
        }
        if(arbol.hasRightChild()) {
            arbSad.addRightChild(new BinaryTree<SumDif>());
            sumAndDifP(arbol.getRightChild(), arbSad.getRightChild(), sum+datoActual, datoActual);
        }
	}
	
}
