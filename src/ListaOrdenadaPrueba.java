import java.util.ArrayList;

import edu.uniquindio.gaso.ed.listadoble.ListaDoble;
import edu.uniquindio.gaso.ed.listadoble.ListaDobleOrdenada;

public class ListaOrdenadaPrueba {

	public static void main(String[] args) {

		ListaDobleOrdenada<Integer> orden = new ListaDobleOrdenada<>();
		
		
		orden.insertar(10);
		orden.insertar(11);
		orden.insertar(9);
		orden.insertar(3);
		orden.insertar(3);
		orden.insertar(1);
		orden.insertar(8);
		orden.insertar(2);
		orden.insertar(0);
		orden.insertar(3);		
		orden.insertar(-1);
		orden.insertar(99);
		orden.insertar(-5);
		orden.insertar(-2);
		orden.insertar(98);
		orden.insertar(6);
		orden.insertar(-20);
		
		ListaDoble<Integer> lista = new ListaDoble<>();
		lista.insertarUltimo(12);
		lista.insertarUltimo(-100);
		lista.insertarUltimo(50);
		lista.insertarUltimo(60);
		lista.insertarUltimo(70);
		lista.insertarUltimo(97);
		
		orden.insertar(lista);
		
		
		for(Integer e : orden){
			System.out.println(e);
		}
		
		
		System.out.println("Fin Lista");
	}

}
