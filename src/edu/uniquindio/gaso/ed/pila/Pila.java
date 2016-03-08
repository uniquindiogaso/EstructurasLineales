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
	
	public void pop(){
		if (!estaVacia()){
			if (tamano == 1){
				top = null;
			}else{
				top = top.getAnterior();
			}
			tamano--;
		}
	
	}
	
	public Nodo<T> getTop(){
		return this.top;
	}

}
