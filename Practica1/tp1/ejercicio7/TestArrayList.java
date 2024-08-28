package tp1.ejercicio7;

import java.util.*;
import practica1.Alumno;
public class TestArrayList {

	public static void main(String[] args) {
		// A
		List<Integer> listInt = new ArrayList <Integer>();
		
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		System.out.println(listInt.get(3));
		for (Integer i: listInt) {
			System.out.println(i);
		}
		
		//B
		
		List<Integer> listInt2 = new LinkedList <Integer>();
		listInt2.add(5);
		listInt2.add(6);
		listInt2.add(7);
		listInt2.add(8);
		System.out.println(listInt2.get(3));
		for (Integer i : listInt2) {
			System.out.println(i);
		}
		
		//C era con for comun y while  pero los hice con for each...
		//D 
		
		List<Alumno> listA = new LinkedList<Alumno>();
		Alumno a1 = new Alumno("a","a","a",1,"a");
		listA.add(a1);
		Alumno a2 = new Alumno("b","b","b",2,"b");
		listA.add(a2);
		Alumno a3 = new Alumno("c","c","c",3,"c");
		listA.add(a3);
		
		List<Alumno> listB = new LinkedList<Alumno>(listA);
		
		for (Alumno i :listA) {
			System.out.println(i);
		}
		System.out.println("----------");
		for (Alumno i :listB) {
			System.out.println(i);
		}
		
		System.out.println("----------");
		a1.setNombre("d");
		
		for (Alumno i :listA) {
			System.out.println(i);
		}
		System.out.println("----------");
		for (Alumno i :listB) {
			System.out.println(i);
		}
		
		//E
		Alumno a4 = new Alumno("d","d","d",4,"d");
		if(!listA.contains(a4)) {
			
			listA.add(a4);
			System.out.println("Se agrego al alumno correctamente");
		}else {
			System.out.println("El alumno se encuentra repetido");
		}
		
	}

}
