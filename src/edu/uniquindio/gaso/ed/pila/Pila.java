package edu.uniquindio.gaso.ed.pila;

import edu.uniquindio.gaso.ed.common.Nodo;

public class Pila<T> {
	private Nodo<T> top;
	private int tamano;
	private int tamanoMax;

	public Pila() {
		this.top = null;
		this.tamano = 0;
		tamanoMax = Integer.MAX_VALUE;
	}

	public Pila(int tamanoMax) {
		this.top = null;
		this.tamano = 0;
		this.tamanoMax = tamanoMax;
	}

	public boolean estaVacia() {
		return top == null;
	}

	public boolean espacioVacio() {
		return tamano < tamanoMax;
	}

	public void push(T dato) {
		Nodo<T> nuevoNodo;
		if (estaVacia()) {
			nuevoNodo = new Nodo<T>(dato);
		} else {
			nuevoNodo = new Nodo<T>(dato, top);
		}
		top = nuevoNodo;
		tamano++;
	}

	public void push1(T dato) {
		// TODO validar tamanio maximo
		Nodo<T> nodoNuevo = new Nodo<T>(dato);
		nodoNuevo.setSiguiente(top);
		top = nodoNuevo;
		tamano++;
	}

	public void pop() {
		if (!estaVacia()) {
			if (tamano == 1) {
				top = null;
			} else {
				top = top.getSiguiente();
			}
			tamano--;
		}

	}

	public T pop1() {
		//TODO no eliminar si la pila esta vacia
		T dato = top.getDato();
		if (!estaVacia()) {
			top = top.getSiguiente();
			tamano--;
		}
		return dato;
	}

	public T peek() {
		return top != null ? top.getDato() : null;
	}

	/**
	 * Método que obtiene la cantidad de elementos de la Estructura
	 * 
	 * @return tamano , numero de elementos de la estructura
	 */
	public int getTamano() {
		return tamano;
	}

}
