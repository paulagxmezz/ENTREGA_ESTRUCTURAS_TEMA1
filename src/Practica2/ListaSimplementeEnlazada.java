package Practica2;

import Interfaces.Iterador;
import Interfaces.Lista;

public class ListaSimplementeEnlazada<T> implements Lista<T> {
    private ElementoSE<T> cabeza;
    public class IteradorSE<T> implements Iterador<T>{
        private ElementoSE<T> actual;
        private ElementoSE<T> anterior;
        public IteradorSE() {
            actual = (ElementoSE<T>) cabeza;
            anterior = null;
        }
        @Override
        public boolean hasNext() {
            return actual != null;
        }
        public T next() {
            if(!hasNext()) {
                return null;
            }
            anterior = actual;
            actual = actual.siguiente;
            return anterior.dato;
        }
        public void delete() {
            if (actual == null) {
                return; // No hay elemento para eliminar
            }
            if (actual == cabeza) {
                cabeza = cabeza.siguiente; // Actualizar la cabeza si se elimina el primer nodo
            } else if (anterior != null) {
                anterior.siguiente = actual.siguiente; // Saltar el nodo actual
            }
            actual = actual.siguiente; // Mover el iterador al siguiente nodo
        }

    }
    public ListaSimplementeEnlazada() {
        this.cabeza = null;
    }
    //Añado un metodo para añadir al inicio para las pilas y colas;
    public boolean addI(T elemento) {
        ElementoSE<T> nuevo = new ElementoSE<>();
        nuevo.dato = elemento;
        if (cabeza == null) {
            cabeza = nuevo;
            return true;
        }
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        return true;
    }
    @Override
    public boolean add(T elemento) {
        ElementoSE<T> nuevo = new ElementoSE<>();
        nuevo.dato = elemento;
        if (this.cabeza == null) {
            this.cabeza = nuevo;
            return true;
        }
        else {
            ElementoSE<T> aux = this.cabeza;
            while (aux.siguiente != null) { // Buscar el ultimo nodo
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo; // Añadir el nuevo nodo al final
        }
        return true;
    }
    //Añado un metodo para eliminar el inicio para las colas y pilas.
    public boolean deleteI(){
        if (cabeza == null) {
            return false;
        }
        cabeza = cabeza.siguiente;
        return true;
    }
    @Override
    public boolean delete(T elemento) {
        if (cabeza == null) {
            return false;
        }
        else if (cabeza.dato == elemento) {
            this.cabeza = cabeza.siguiente;
            return true;
        }
        else{
            ElementoSE<T> aux = cabeza;
            while (aux.siguiente != null) {
                if (aux.siguiente.dato.equals(elemento)) {
                    aux.siguiente = aux.siguiente.siguiente;
                    return true;
                }
                aux = aux.siguiente;
            }
            return false;
        }
    }
    @Override
    public int getNumElementos() {
        if (this.cabeza == null) {
            return 0;
        }
        else {
            ElementoSE<T> aux = this.cabeza;
            int contador = 0;
            while (aux != null) {
                aux = aux.siguiente;
                contador++;
            }
            return contador;
        }
    }
    @Override
    public Iterador<T> getIterador(){
        return new IteradorSE<T>();
    }

}
