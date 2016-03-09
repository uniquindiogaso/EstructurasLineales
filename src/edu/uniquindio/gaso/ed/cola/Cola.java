package edu.uniquindio.gaso.ed.cola;

import edu.uniquindio.gaso.ed.common.Nodo;

public class Cola<T> {

	private Nodo<T> primero;
	private Nodo<T> ultimo;
	private int tamano;

	public Cola() {
		this.primero = null;
		this.ultimo = null;
		tamano = 0;
	}

	public boolean estaVacia() {
		return tamano == 0;
	}

	public void enqueve(T dato) {
		Nodo<T> nuevoNodo = null;
		if (estaVacia()) {
			nuevoNodo = new Nodo<T>(dato);
			primero = ultimo = nuevoNodo;
		} else {
			nuevoNodo = new Nodo<T>(dato,ultimo,null);
			ultimo.setAnterior(nuevoNodo);
			ultimo = nuevoNodo;

			
			
		}
		tamano++;
	}
	
	public void dequeve(){
		if (!estaVacia()){
	
			primero = primero.getAnterior();
			primero.setSiguiente(null);
		
			tamano--;
		
		}
	}

}
