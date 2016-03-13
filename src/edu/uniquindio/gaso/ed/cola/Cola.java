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
	
	public T dequeve(){
		T dato  = null;
		if (!estaVacia()){
			dato = primero.getDato();
			primero = primero.getAnterior();
			if ( primero != null){
				primero.setSiguiente(null);
			}
			
		
			tamano--;
		
		}
		
		return dato;
	}
	
	/**
	 * Obtener valor de la Cabeza de la Estructura
	 * 
	 * @return dato contenido en la cabeza de la estructura
	 */
	public T obtenerPrimero() {
		return primero == null ? null : primero.getDato();
	}

}
