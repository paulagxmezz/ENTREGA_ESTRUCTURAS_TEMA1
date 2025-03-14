package Practica4;

import Practica2.ElementoSE;
import Practica2.ListaSimplementeEnlazada;

public class Pila<T>{
    private ListaSimplementeEnlazada<T> lista;
    private T elemento;
    public Pila() {
        lista = new ListaSimplementeEnlazada<T>();
    }
    public void push(T elemento) {
        lista.addI(elemento);
    }
    public T pop() {

        elemento = lista.getIterador().next();
        lista.deleteI();
        return elemento;
    }
}
