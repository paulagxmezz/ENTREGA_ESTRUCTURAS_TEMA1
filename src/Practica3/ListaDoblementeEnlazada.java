package Practica3;

import Interfaces.Iterador;
import Interfaces.Lista;

import javax.swing.text.Element;

public class ListaDoblementeEnlazada<T> implements Lista<T> {
    private ElementoDE<T> cabeza;
    private ElementoDE<T> cola;
    public class IteradorDE<T> implements Iterador<T> {
        //SI SE PODRIA IMPLEMENTAR UN hasPrevious() y un previous() para poder recorrer la lista hacia atrás (desde el final hasta el principio), se haría usando otra variable "actual2" y recorriendo la lista hacia atrás, cuya implementación es análoga que hacia alante:
        private ElementoDE<T> actual;
        private ElementoDE<T> previo;
        public IteradorDE() {
            actual = (ElementoDE<T>) cabeza;
            previo = null;
        }
        @Override
        public boolean hasNext() {
            return actual != null;
        }
        @Override
        public T next() {
            if (!hasNext()) {
                return null;
            }
            previo = actual;
            actual = actual.siguiente;
            return previo.dato;
        }
        @Override
        public void delete(){
            if (cabeza == cola){
                cabeza = null;
                cola = null;
                actual = null;
            }
            else if (actual == cabeza){
                cabeza = cabeza.siguiente;
                cabeza.anterior = null;
                actual = (ElementoDE<T>) cabeza;
            }
            else if (actual == cola){
                cola = cola.anterior;
                cola.siguiente.anterior = null;
                cola.siguiente = null;
                actual = null;
            }
            else{
                previo.siguiente = actual.siguiente;
                actual = actual.siguiente;
                actual.anterior = previo;
            }
        }
    }
    public ListaDoblementeEnlazada() {
        cabeza = null;
        cola = null;
    }
    @Override
    public boolean add(T elemento) {
        ElementoDE<T> nuevo = new ElementoDE<>();
        nuevo.dato = elemento;
        if (cola == null) {
            cola = nuevo;
            cabeza = nuevo;
            return true;
        }
        else if (cola == cabeza) {
            cola.siguiente = nuevo;
            nuevo.anterior = cabeza;
            cola = nuevo;
            return true;
        }
        else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
            return true;
        }
    }
    @Override
    public boolean delete(T elemento) {
        if (cola == null) {
            return false;
        }
        else if (cola == cabeza) {
            cola = null;
            cabeza = null;
            return true;
        }
        else if (cabeza.dato == elemento) {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
            return true;
        }
        else if (cola.dato == elemento) {
            cola = cola.anterior;
            cola.siguiente = null;
            return true;
        }
        else {
            ElementoDE<T> aux = cabeza.siguiente;
            while (aux != null) {
                if (aux.dato == elemento) {
                    aux.anterior.siguiente = aux.siguiente;
                    aux.siguiente.anterior = aux.anterior;
                    return true;
                }
                aux = aux.siguiente;
            }
            return false;
        }
    }
    @Override
    public int getNumElementos() {
        ElementoDE<T> aux = cabeza;
        int contador = 0;
        while (aux != null) {
            contador++;
            aux = aux.siguiente;
        }
        return contador;
    }
    @Override
    public Iterador<T> getIterador() {
        return new IteradorDE();
    }

}
