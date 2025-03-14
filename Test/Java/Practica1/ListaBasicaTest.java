package Practica1;

import Interfaces.Iterador;
import Interfaces.Lista;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ListaBasicaTest {
    @Test
    void testListaBasica() {
        Lista<Integer> lista = new ListaBasica<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.delete(2);
        List<Integer> resultado = new ArrayList<>();
        Iterador<Integer> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }
        assertEquals(List.of(1, 3), resultado);
    }

    @Test
    void getNumElementos() {
        Lista<Integer> lista = new ListaBasica<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        assertEquals(3, lista.getNumElementos());
    }

    @Test
    void add() {
        Lista<Integer> lista = new ListaBasica<>();
        assertTrue(lista.add(1));
        assertTrue(lista.add(2));
        assertEquals(2, lista.getNumElementos());
        ListaBasica<Integer> lista2 = new ListaBasica<>(2);
        assertTrue(lista2.add(1));
        assertTrue(lista2.add(2));
        assertFalse(lista2.add(3)); // No se debe poder añadir más
        assertEquals(2, lista2.getNumElementos());
    }

    @Test
    void delete() {
        Lista<Integer> lista = new ListaBasica<>();
        lista.add(1);
        lista.add(2);
        assertTrue(lista.delete(1));
        assertEquals(1, lista.getNumElementos());
        ListaBasica<Integer> lista2 = new ListaBasica<>(2);
        lista2.add(1);
        lista2.add(2);
        assertFalse(lista2.delete(3)); // Elemento no presente
        assertEquals(2, lista2.getNumElementos());
    }

    @Test
    void getIterador() {
    }
    @Test
    void testIterador() {
        ListaBasica<Integer> lista = new ListaBasica<>();
        lista.add(1);
        lista.add(2);
        Iterador<Integer> iterador = lista.getIterador();
        assertTrue(iterador.hasNext());
        assertEquals(1, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(2, iterador.next());
        assertFalse(iterador.hasNext());
        assertEquals(null, iterador.next());
        lista.delete(2);
        iterador = lista.getIterador();
        iterador.delete();
        List<Integer> resultado = new ArrayList<>();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }
        assertEquals(List.of(), resultado);
    }

    @Test
    void testIteradorDelete() {
        ListaBasica<Integer> lista = new ListaBasica<>();
        lista.add(1);
        lista.add(2);
        Iterador<Integer> iterador = lista.getIterador();
        iterador.delete(); // Mueve al primer elemento
        assertEquals(1, lista.getNumElementos());
        assertEquals(2, lista.getIterador().next()); // El primer elemento ahora es 2
    }
}