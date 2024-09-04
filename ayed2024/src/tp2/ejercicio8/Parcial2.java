package tp2.ejercicio8;

import tp2.ejercicio1.*;

public class Parcial2 {
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        if(arbol1.isEmpty() || arbol2.isEmpty()) 
            return arbol1.isEmpty() && arbol2.isEmpty(); //El primer if verifica si al menos uno de los arboles esta vacio, si es asi, pregunta si ambos arboles estan vacios, si es asi tienen la misma estructura, en caso contrario, no es prefijo
        return esPrefijoHelper(arbol1, arbol2); //Si entre aca es porque los 2 arboles tienen al menos un dato y puedo hacer la comparacion correspondiente
    }
    
    private boolean esPrefijoHelper(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        if(arbol1.getData() != arbol2.getData()) {
            return false;
        } 
        boolean res = true;
        if(arbol1.hasLeftChild()) {
            if(arbol2.hasLeftChild()) {
                res = res && esPrefijoHelper(arbol1.getLeftChild(), arbol2.getLeftChild()); //Verifico que tengan el mismo contenido
            } else return false; //No poseen la misma estructura
        }
        if(arbol1.hasRightChild()) {
            if(arbol2.hasRightChild()) {
                res = res && esPrefijoHelper(arbol1.getRightChild(), arbol2.getRightChild()); //Verifico que tengan el mismo contenido 
            } else return false; //No poseen la misma estructura
        }
        return res;
    }
}
