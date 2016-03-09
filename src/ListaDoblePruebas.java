import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.uniquindio.gaso.ed.listadoble.ListaDoble;

public class ListaDoblePruebas {

	public static void main(String[] args) {
		

		ListaDoble<Integer> lista = new ListaDoble<Integer>();
		
		lista.insertarUltimo(3);
		lista.insertarUltimo(2);
		lista.insertarDespuesDe(5, 3);

		
		
		

		
		for(Integer l1 : lista){
			System.out.println("=> "+l1);
		}


	}

}
