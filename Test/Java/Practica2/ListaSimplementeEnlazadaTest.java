package Practica2;

import Interfaces.Iterador;
import Interfaces.Lista;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListaSimplementeEnlazadaTest {
    @Test
    void testListaSimplementeEnlazada() {
        Lista<Integer> lista = new ListaSimplementeEnlazada<>();
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.delete(20);
        List<Integer> resultado = new ArrayList<>();
        Iterador<Integer> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }
        assertEquals(List.of(10, 30), resultado);
    }
    ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>();

    @Test
    void add() {
    }

    @Test
    void delete() {
        ListaSimplementeEnlazada<Integer> lista2 = new ListaSimplementeEnlazada<>();
        lista2.add(1);
        lista2.add(2);
        lista2.add(3);
        assertTrue(lista2.deleteI());
        assertEquals(2, lista2.getNumElementos());
        assertEquals(false, lista2.delete(5));
        lista2.delete(2);
        lista2.delete(3);
        assertEquals(false, lista2.delete(1));
        assertFalse(lista2.deleteI());
        lista2.add(4);
        lista2.add(5);
        lista2.addI(2);
        Iterador<Integer> iterador3 = lista2.getIterador();
        assertEquals(2, iterador3.next());
        iterador3.delete();
        iterador3.delete();
        lista2.delete(2);
        lista2.addI(3);
        lista2.add(4);
        Iterador<Integer> iterador4 = lista2.getIterador();
        assertEquals(3, iterador4.next());
        assertEquals(4, iterador4.next());

    }

    @Test
    void getNumElementos() {
        Lista<Integer> lista2 = new ListaSimplementeEnlazada<>();
        assertEquals(0, lista2.getNumElementos());
    }

    @Test
    void getIterador() {
        lista.add(10);
        lista.add(20);
        Iterador<Integer> iterador = lista.getIterador();
        iterador.delete();
        iterador.delete();
        assertEquals(null, iterador.next());
        Iterador<Integer> iterador2 = lista.getIterador();
        List<Integer> resultado = new ArrayList<>();
        while (iterador2.hasNext()) {
            resultado.add(iterador2.next());
        }
        assertEquals(List.of(), resultado);

        lista.add(1);
        lista.add(2);
        lista.add(3);
        Iterador<Integer> iterador3 = lista.getIterador();
        iterador3.next();
        iterador3.delete();
        iterador3.next();
        iterador3.delete();
        assertEquals(2, lista.getNumElementos());
    }
}