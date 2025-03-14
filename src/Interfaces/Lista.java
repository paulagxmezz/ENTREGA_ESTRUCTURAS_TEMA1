package Interfaces;

public interface Lista<T> {
    public boolean add(T elemento);
    public boolean delete(T elemento);
    public Iterador<T> getIterador();
    public int getNumElementos();
}
