package Practica3;

public class ElementoDE<T> {
    T dato;
    ElementoDE anterior;
    ElementoDE siguiente;
    public ElementoDE() {
        dato = null;
        anterior = null;
        siguiente = null;
    }
}
