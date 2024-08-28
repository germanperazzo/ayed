package tp1.ejercicio7;

import java.util.*;

public class Capicua {

	//1ra Forma
    public boolean itera(ArrayList<Integer> lista) {
        boolean es = true;
        if(!lista.isEmpty()) {
            int pri = 0;
            int ult = lista.size() - 1;
            while((pri < ult) && es) {
                if (lista.get(pri).equals(lista.get(ult))) {
                    pri++;
                    ult--;
                }
                else es = false;
            }
        }
        return es;
    }
    
    //2da Forma
    public static boolean recu(List<Integer> lista) {
        if(lista.isEmpty() || lista.size() == 1) return true;
        else
            if(!lista.get(0).equals(lista.get(lista.size()-1))) return false; //Si los primeros y ultimos elementos no coinciden, no es un palindromo
            else
                return recu(lista.subList(1, lista.size()-1)); //Llama recursivamente a esPalindromo con una subLista sin los primeros y ultimos elementos
    }
    
	public static void main (String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		 list.add(2);
	     list.add(4);
	     list.add(4);
	     list.add(2);
	    ArrayList<Integer> list2 = new ArrayList<Integer>();
	    
	     list2.add(1);
	     list2.add(3);
	     list2.add(4);
	     list2.add(2);
	     
	     Capicua c = new Capicua();
	     System.out.println(c.itera(list2));
	     System.out.println(c.itera(list));
	     System.out.println(c.itera(list2));
	     System.out.println(c.itera(list));
	}
}
