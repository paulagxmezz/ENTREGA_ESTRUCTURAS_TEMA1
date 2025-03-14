package Practica3;

import Interfaces.Iterador;
import Interfaces.Lista;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListaDoblementeEnlazadaTest {
    @Test
    void testListaDoblementeEnlazada() {
        Lista<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.add(5);
        lista.add(15);
        lista.add(25);
        lista.delete(15);
        List<Integer> resultado = new ArrayList<>();
        Iterador<Integer> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }
        assertEquals(List.of(5, 25), resultado);
    }

    @Test
    void add() {
    }

    @Test
    void delete() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.add(5);
        lista.add(15);
        assertEquals(false,lista.delete(-4));
        lista.delete(15);
        lista.delete(5);
        assertEquals(false, lista.delete(6));
        List<Integer> resultado = new ArrayList<>();
        Iterador<Integer> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }
        assertEquals(List.of(), resultado);
        lista.add(5);
        lista.add(15);
        assertEquals(true, lista.delete(5));
    }

    @Test
    void getNumElementos() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.add(5);
        lista.add(15);
        assertEquals(2,lista.getNumElementos());
        lista.delete(5);
        lista.delete(15);
        assertEquals(0,lista.getNumElementos());
    }

    @Test
    void getIterador() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        Iterador<Integer> iterador = lista.getIterador();
        assertEquals(null, iterador.next());
        lista.add(5);
        lista.add(15);
        lista.add(25);
        lista.add(35);
        Iterador<Integer> iterador2 = lista.getIterador();
        iterador2.delete();
        assertEquals(15, iterador2.next());
        iterador2.delete();
        iterador2.delete();
        assertEquals(null, iterador2.next());
        Iterador<Integer> iterador3 = lista.getIterador();
        iterador3.delete();
        assertEquals(null, iterador3.next());
    }
}