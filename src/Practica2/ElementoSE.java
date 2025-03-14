package Practica2;

public class ElementoSE<T> {
    ElementoSE<T> siguiente;
    T dato;
    public ElementoSE() {
        siguiente = null;
        dato = null;
    }
}
