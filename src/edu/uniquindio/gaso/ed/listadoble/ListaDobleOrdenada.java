package edu.uniquindio.gaso.ed.listadoble;

import java.util.Collection;
import java.util.Iterator;
import edu.uniquindio.gaso.ed.common.Nodo;

/**
 * <h1>Lista doblemente enlazada</h1> estructura de datos que consiste en un
 * conjunto de nodos enlazados secuencialmente. Cada nodo contiene dos
 * referencias, llamados enlaces, que son referencias al nodo siguiente y al
 * anterior en la secuencia de nodos
 *
 * @author Gustavo Salgado Ocampo
 * @version 1.0
 * @since 2016-03-06
 * @see https://es.wikipedia.org/wiki/Lista_doblemente_enlazada
 */
public class ListaDobleOrdenada<T> implements Iterable<T> {

	// Referencia al Primer Elemento de la Estructura
	private Nodo<T> cabeza;
	// Referencia al ultimo elemento de la Estructura
	private Nodo<T> cola;
	// Tamanio que tienen la estructura
	private int tamano;

	/**
	 * Constructor de Lista Doblemente Enlazada
	 */
	public ListaDobleOrdenada() {
		this.cabeza = null;
		this.cola = null;
		this.tamano = 0;
	}

	/**
	 * Comprobar si Estructura esta vacia
	 * 
	 * @return boolean con valor true si la estructura esta vacia o false si
	 *         tiene por lo menos un dato
	 */
	public boolean estaVacia() {
		return this.cabeza == null;
	}

	/**
	 * Agregar elemento de manera ordenada a la Lista Doble
	 * 
	 * @param dato
	 *            Objeto a ingresar a la Lista
	 */
	public void insertar(T dato) {
		Nodo<T> nuevoNodo;

		if (estaVacia()) {
			nuevoNodo = new Nodo<>(dato);
			cabeza = cola = nuevoNodo;
		} else {

			Nodo<T> nodoBase = cabeza;

			while (nodoBase != null) {

				// ( va despues )
				if (nodoBase.compareTo(dato) == -1) {

					// Es el ultimo
					if (nodoBase == cola) {
						nuevoNodo = new Nodo<>(dato, null, nodoBase);
						nodoBase.setSiguiente(nuevoNodo);
						cola = nuevoNodo;
						tamano++;
						break;
					}

				} else {
					// Puede ir antes

					nuevoNodo = new Nodo<>(dato, nodoBase);

					if (nodoBase != cabeza) {
						nodoBase.getAnterior().setSiguiente(nuevoNodo);
						nuevoNodo.setAnterior(nodoBase.getAnterior());
						nodoBase.setAnterior(nuevoNodo);
					} else {
						nodoBase.setAnterior(nuevoNodo);
						cabeza = nuevoNodo;
					}

					tamano++;
					break;
				}

				nodoBase = nodoBase.getSiguiente();

			}
		}

	}
	
	/**
	 * Permite Insertar de Manera Ordenada una coleccion de objetos
	 * @param coleccion Lista Doble que contiene los objetos a insertar
	 */
	public void insertar(ListaDoble<T> coleccion) {
		Iterator<T> iterador = coleccion.iterator();
		while(iterador.hasNext()){
			insertar(iterador.next());
		}
	}

	/**
	 * Vaciar contenido de la Estructura, inicializando las refencias de cabeza
	 * y cola , asi como la cantidad de elementos.
	 */
	public void eliminarTodo() {
		cabeza = cola = null;
		tamano = 0;
	}

	/**
	 * Quitar el primer elemento de la estructura, asignando cabeza al elemento
	 * siguiente
	 */
	public void eliminarPrimero() {
		if (!estaVacia()) {
			// Si ambos son iguales , debe existir un solo elemento
			if (cabeza == cola) {
				eliminarTodo();
			} else {
				cabeza = cabeza.getSiguiente();
				cabeza.setAnterior(null);
				tamano--;
			}

		}
	}

	/**
	 * Quitar el ultimo elemento de la estructura, asignando cola al elemento
	 * anterior
	 */
	public void eliminarUltimo() {
		if (!estaVacia()) {
			// Si ambos son iguales , debe existir un solo elemento
			if (cabeza == cola) {
				eliminarTodo();
			} else {
				Nodo<T> nuevoUltimo = cola.getAnterior();
				cola = nuevoUltimo;
				cola.setSiguiente(null);
				tamano--;
			}
		}
	}

	/**
	 * Elimina de la estructura el elemento recibido como parametro
	 * 
	 * @param dato
	 *            , elemento de la lista a borrar de la estructura.
	 */
	public void eliminar(T dato) {
		Nodo<T> nodoEliminar = buscar(dato);
		if (nodoEliminar != null) {
			if (nodoEliminar == cabeza) {
				eliminarPrimero();
			} else if (nodoEliminar == cola) {
				eliminarUltimo();
			} else {
				nodoEliminar.getAnterior().setSiguiente(nodoEliminar.getSiguiente());
				nodoEliminar.getSiguiente().setAnterior(nodoEliminar.getAnterior());
				tamano--;
			}

		}
	}

	/**
	 * Permite quitar de la estructura los datos que se encuentres despues de un
	 * Dato suministrado como parametro
	 * 
	 * @param dato
	 *            , dato que se utilizara como base para borrar los elementos
	 *            siguientes a el.
	 */
	public void eliminarDespuesDe(T dato) {
		Nodo<T> nodoBase = buscar(dato);
		if (nodoBase != null) {
			if (tamano == 1) {
				eliminarTodo();
			} else {

				int restar = 0;

				Nodo<T> nodoRecorrido = nodoBase;

				while (nodoRecorrido.getSiguiente() != null) {
					restar++;
					nodoRecorrido = nodoRecorrido.getSiguiente();
				}

				nodoBase.setSiguiente(null);
				cola = nodoBase;
				tamano = tamano - restar;

			}
		}
	}

	/**
	 * Permite quitar de la estructura los datos que se encuentres antes de un
	 * Dato suministrado como parametro
	 * 
	 * @param dato
	 *            , dato que se utilizara como base para borrar los elementos
	 *            anteriores a el.
	 */
	public void eliminarAntesDe(T dato) {
		Nodo<T> nodoBase = buscar(dato);
		if (nodoBase != null) {
			if (tamano == 1) {
				eliminarTodo();
			} else {

				int restar = 0;

				Nodo<T> nodoRecorrido = nodoBase;

				while (nodoRecorrido.getAnterior() != null) {
					restar++;
					nodoRecorrido = nodoRecorrido.getAnterior();
				}

				nodoBase.setAnterior(null);
				cabeza = nodoBase;
				tamano = tamano - restar;

			}
		}
	}

	/**
	 * Buscar Nodo dentro de la Estructura
	 * 
	 * @param dato
	 *            , informacion a buscar
	 * @return Nodo que contiene la informacion buscada, retorna la primer
	 *         coincidencia
	 */
	public Nodo<T> buscar(T dato) {
		Nodo<T> nodoEncontrado = null;
		if (!estaVacia()) {

			Nodo<T> nodoTemporal = cabeza;

			while (nodoTemporal != null) {
				if (dato == nodoTemporal.getDato()) {
					nodoEncontrado = nodoTemporal;
					break;
				}
				nodoTemporal = nodoTemporal.getSiguiente();
			}

		}

		return nodoEncontrado;
	}

	/**
	 * Obtener valor de la Cabeza de la Estructura
	 * 
	 * @return dato contenido en la cabeza de la estructura
	 */
	public T obtenerPrimero() {
		return cabeza.getDato();
	}

	/**
	 * Obtener valor de la Cola de la Estructura
	 * 
	 * @return dato contenido en la cola de la estructura
	 */
	public T obtenerUltimo() {
		return cola.getDato();
	}

	/**
	 * Método que obtiene la cantidad de elementos de la Estructura
	 * 
	 * @return tamano , numero de elementos de la estructura
	 */
	public int getTamano() {
		return tamano;
	}

	/**
	 * Metodo sobreescrito que indica el iterador por defecto a usar cuando se
	 * requiera recorrer la estructura
	 * 
	 * @return Instancia a iterador por defecto
	 */
	@Override
	public Iterator<T> iterator() {
		return new IteradorCuentaAdelante(cabeza);
	}

	/**
	 * Iterador para Conteos regresivos, permite hacer el recorrido de los
	 * elementos desde el ultimo al primero
	 * 
	 * @return Instancia a iterador de cuenta hacia atras
	 */
	public Iterator<T> iteratorCuentaAtras() {
		return new IteradorCuentaAtras(cola);
	}

	/**
	 * <h1>Iterador General</h1> Clase que define la forma en como seran
	 * recorridos los elementos de la estructura, este tipo de recorrido se le
	 * ha llamado general, ya que parte de la cabeza hasta la cola.
	 *
	 * @author Gustavo Salgado Ocampo
	 * @version 1.0
	 * @since 2016-03-06
	 */
	class IteradorCuentaAdelante implements Iterator<T> {

		protected Nodo cabeza;
		protected Nodo actual;
		protected int posicion;

		/**
		 * Constructor Iterador Cuenta hacia adelante
		 * 
		 * @param cabeza
		 *            Nodo que representara el primer elemento a iterar
		 */
		public IteradorCuentaAdelante(Nodo cabeza) {
			this.cabeza = this.actual = cabeza;
			this.posicion = 0;
		}

		@Override
		public boolean hasNext() {
			return actual != null;
		}

		@Override
		public T next() {
			T dato = (T) actual.getDato();
			actual = actual.getSiguiente();
			posicion++;
			return dato;
		}

		public int getPosicion() {
			return posicion;
		}

	}

	/**
	 * <h1>Iterador Cuenta Atras</h1> Clase que define el recorrido de atras
	 * hacia adelante en la estructura, este toma como referencia la cola y va
	 * avanzando hasta llegar a la cabeza.
	 *
	 * @author Gustavo Salgado Ocampo
	 * @version 1.0
	 * @since 2016-03-06
	 */
	class IteradorCuentaAtras implements Iterator<T> {

		protected Nodo cola;
		protected Nodo actual;
		protected int posicion;

		/**
		 * Constructor Iterador Cuenta hacia atras
		 * 
		 * @param cola
		 *            Nodo que representara el primer elemento a iterar
		 */
		public IteradorCuentaAtras(Nodo cola) {
			this.cola = actual = cola;
			posicion = getTamano();
		}

		@Override
		public boolean hasNext() {
			return actual != null;
		}

		@Override
		public T next() {
			T dato = (T) actual.getDato();
			actual = actual.getAnterior();
			posicion--;
			return dato;
		}

	}

}
