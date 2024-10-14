package org.iesvdm.ejercicio7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperableTest {

    @Test
    void testOperableOperations() {

        // creo e instancio la clase anonima que implementa la interfaz Operable
        Operable<Integer> operable = new Operable<Integer>() {
            private int valor = 10;

            public int getValor() {
                return valor;
            }

            @Override
            public Integer sumar(Integer o) {
                return valor + o;
            }

            @Override
            public Integer restar(Integer o) {
                return valor - o;
            }

            @Override
            public Integer multiplicar(Integer o) {
                return valor * o;
            }

            @Override
            public Integer dividir(Integer o) {
                if (o == 0) {
                    throw new ArithmeticException("División por cero no permitida");
                }
                return valor / o;
            }

            @Override
            public String toString() {
                return "Valor actual: " + valor;
            }
        };

        // Probando las operaciones
        int suma = operable.sumar(5);
        System.out.println("Resultado de la suma: 10+5=" + suma);
        assertEquals(15, suma, "La suma debe ser 15");


        int resta = operable.restar(3);
        System.out.println("Resultado de la resta: 10-3=" + resta);
        assertEquals(7, resta, "La resta debe ser 7");


        int multiplicacion = operable.multiplicar(2);
        System.out.println("Resultado de la multiplicación: 10*3=" + multiplicacion);
        assertEquals(20, multiplicacion, "La multiplicación debe ser 20");

        int division = operable.dividir(5);
        System.out.println("Resultado de la división: 10/5=" + division);
        assertEquals(2, division, "La división debe ser 2");

        assertThrows(ArithmeticException.class, () -> {
            System.out.println("No se puede dividir entre 0");
            operable.dividir(0);
        }, "Debe lanzar una ArithmeticException por dividir entre cero");

    }

}