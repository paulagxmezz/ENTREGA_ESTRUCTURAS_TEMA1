package Practica4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilaTest {
    @Test
    void testPilaYCola() {
        Pila<Integer> pila = new Pila<>();
        pila.push(1);
        pila.push(2);
        assertEquals(2, pila.pop());
        Cola<Integer> cola = new Cola<>();
        cola.enqueue(10);
        cola.enqueue(20);
        assertEquals(10, cola.dequeue());
    }

    @Test
    void push() {
    }

    @Test
    void pop() {
    }

    @Test
    void testPush() {
    }

    @Test
    void testPop() {
    }
}