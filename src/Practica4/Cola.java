package Practica4;

import Practica2.ListaSimplementeEnlazada;

public class Cola<T> {
    private ListaSimplementeEnlazada<T> lista;
    private T elemento;
    public Cola() {
        lista = new ListaSimplementeEnlazada<T>();
    }
    public void enqueue(T elemento) {
        lista.add(elemento);
    }
    public T dequeue() {
        elemento = lista.getIterador().next();
        lista.deleteI();
        return elemento;
    }
}
