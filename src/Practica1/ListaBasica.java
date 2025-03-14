package Practica1;

import Interfaces.Iterador;
import Interfaces.Lista;
public class ListaBasica<T> implements Lista<T> {
    private T[] elementos;
    private int numElementos;
    private int maxElementos;
    class IteradorLB<T> implements Iterador<T> {
        private int actual;

        public IteradorLB() {
            this.actual = 0;
        }

        @Override
        public boolean hasNext() {
            return actual < numElementos;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                return null;
            }
            return (T) elementos[actual++];
        }

        @Override
        public void delete() {
            if (numElementos<=1) {
                numElementos = 0;
                return; // Si no hay elemento para eliminar o solo uno
            }
            // Desplazar todos los elementos a la izq.
            for (int i = actual; i < numElementos - 1; i++) {
                elementos[i] = elementos[i + 1];
            }

            // Limpiar la última posición
            elementos[numElementos - 1] = null;
            numElementos--;
        }
    }

    public ListaBasica() {
        this.elementos = (T[]) new Object[0];
        this.numElementos = 0;
        this.maxElementos = -1; // Representa que no hay un maximo de elementos
    }

    public ListaBasica(int tamano) {
        this.maxElementos = tamano;
        this.elementos = (T[]) new Object[tamano];
        this.numElementos = 0;
    }

    @Override
    public int getNumElementos() {
        return this.numElementos;
    }

    @Override
    public boolean add(T elemento) {
        // Verificar si se puede añadir más elementos
        if (this.maxElementos != -1 && this.numElementos >= this.maxElementos) {
            return false;
        }

        // Si el array está lleno aumentamos su tamaño
        if (numElementos == elementos.length) {
            T[] nuevoArray = (T[]) new Object[elementos.length+1];
            for (int i = 0; i < numElementos; i++) {
                nuevoArray[i] = elementos[i];
            }
            elementos = nuevoArray;
        }
        elementos[numElementos] = elemento;
        numElementos++;
        return true;
    }

    @Override
    public boolean delete(T elemento) {
        // Buscar el elemento
        int pos = -1;
        for (int i = 0; i < numElementos; i++) {
            if (elemento == elementos[i]) {
                pos = i;
            }
        }
        // Si no se encuentra el elemento deberia retornar falso
        if (pos == -1) {
            return false;
        }
        // Desplazar los elementos a la izq y dejar el final vacio
        for (int i = pos; i < numElementos - 1; i++) {
            elementos[i] = elementos[i + 1];
        }

        elementos[numElementos - 1] = null;
        numElementos--;
        return true;
    }

    @Override
    public Iterador<T> getIterador() {
        return new IteradorLB<>();
    }
}
